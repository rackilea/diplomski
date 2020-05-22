historyResponse.tasks.tasks.forEach(editTaskMsgResponse -> {
            Map<String, Object> msgObject = editTaskMsgResponse.source.msg;
            String taskType = (String) msgObject.get("task_type");
            EditTaskType editTaskType = EditTaskType.valueOf(taskType);
            switch(editTaskType) {
                case MIGRATE_PLACE: 
                    try {
                        returnMsgList.add(objectMapper.readValue(objectMapper.writeValueAsString(msgObject), MatchingTaskOperatorMetricsMsg.class));
                    }
                    catch(IOException io) {}
                case CURATE_PLACE:
                case QC_PLACE: 
                    try {
                        returnMsgList.add(objectMapper.readValue(objectMapper.writeValueAsString(msgObject), MatchingTaskOperatorMetricsMsg.class));
                    }
                    catch(IOException io) {}
            }
        });