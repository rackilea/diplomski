PeriodicTask task = new PeriodicTask.Builder()
        .setService(MyTaskService.class)
        .setTag(TASK_TAG_PERIODIC)
        .setPeriod(30L)
        .build();

mGcmNetworkManager.schedule(task);