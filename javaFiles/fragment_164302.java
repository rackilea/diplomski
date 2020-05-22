WorkflowJob job = oozieClient.getJobInfo("oozie-wf-id");

String data = job.getActions().stream()
        .filter(action -> "shell-5ed8".equals(action.getName()))
        .map(WorkflowAction::getData)
        .findFirst().orElse("");

Properties actionProperties = new Properties();
actionProperties.load(new StringReader(data));