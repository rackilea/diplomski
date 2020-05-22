JobExecutor jobExecutor = ((ProcessEngineConfigurationImpl) processEngine.getProcessEngineConfiguration()).getJobExecutor();
    if (jobExecutor.isActive()) {
        jobExecutor.shutdown();
    } else {
        jobExecutor.start();
    }