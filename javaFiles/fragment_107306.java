Queue queue = QueueFactory.getQueue("QUEUE_NAME");
    queue.add(TaskOptions.Builder
            .withUrl("/url/path")
            .param("key", "PARAM")
            .header("Host",
                    ModulesServiceFactory.getModulesService().getInstanceHostname("MODULE_NAME", "VERSION", "INSTANCE_NAME"));