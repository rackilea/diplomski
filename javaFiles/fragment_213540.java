ExecutorService es=Executors.newFixedThreadPool(Math.min(managedInstances.size(), 100));
es.invokeAll(managedInstances.stream()
    .<Callable<Void>>map(item -> () -> {
        while(!getVersion(item).equals(expectedVersion)) Thread.sleep(5000);
        return null;
    }).collect(Collectors.toList()));
es.shutdown();