public void processControlMessage(final Message message) {
    try {
        lock.lock();
        RDPWorkflowControlMessage rdpWorkflowControlMessage = unmarshallControlMessage(message);
        final String workflowName = rdpWorkflowControlMessage.getWorkflowName();
        final String controlMessageEvent = rdpWorkflowControlMessage.getControlMessage().value();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (message instanceof TextMessage) {
                        if ("REFRESH".equalsIgnoreCase(controlMessageEvent)) {
                            if (tryAddingWorkflowNameInStatusMap(workflowName)) {
                                log.info("Processing Workflow Control Message for the workflow :"+ workflowName);
                                addShutdownHook(workflowName);
                                clearControlMessageBuffer();
                                List<String> matchingValues = new ArrayList<String>();
                                matchingValues.add(workflowName);
                                ConcreteSetDAO tasksSetDAO = taskEventListener.getConcreteSetDAO();
                                ConcreteSetDAO workflowSetDAO = workflowEventListener.getConcreteSetDAO();
                                tasksSetDAO.deleteMatchingRecords(matchingValues);
                                workflowSetDAO.deleteMatchingRecords(matchingValues);
                                List<RDPWorkflowTask> allTasks=fetchNewWorkflowItems(workflowName);
                                updateTasksAndWorkflowSet(allTasks);
                                removeWorkflowNameFromProcessingMap(workflowName);

                            } else {
                                log.info("Cache clean up is already in progress for the workflow ="+ workflowName);
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                    log.error("Error extracting item of type RDPWorkflowControlMessage from message "
                            + message);
                }
            }
        }).start();
    } finally {
        lock.unlock();
    }
}

private boolean tryAddingWorkflowNameInStatusMap(final String workflowName) {
    if(controlMessageStateMap.get(workflowName)==null){
        synchronized (this) {
             if(controlMessageStateMap.get(workflowName)==null){
                 log.info("Adding an entry in to the map for the workflow ="+workflowName);
                 controlMessageStateMap.put(workflowName, true);
                 return true;
             }
        }
    }
    return false;
}

private synchronized void removeWorkflowNameFromProcessingMap(String workflowName) {
    if (workflowName != null
            && (controlMessageStateMap.get(workflowName) != null && controlMessageStateMap
                    .get(workflowName))) {
        controlMessageStateMap.remove(workflowName);
        log.info("Thread processing the " + workflowName+ " is released from the status map");
    }
}