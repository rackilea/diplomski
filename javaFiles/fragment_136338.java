PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
    Applications applications = registry.getApplications();

    applications.getRegisteredApplications().forEach((registeredApplication) -> {
        registeredApplication.getInstances().forEach((instance) -> {
            System.out.println(instance.getAppName() + " (" + instance.getInstanceId() + ") : " + response);
        });
    });