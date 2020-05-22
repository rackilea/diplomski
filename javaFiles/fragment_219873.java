CreateDummyGroups create = new CreateDummyGroups();
Map<ThreadGroup, List<Thread>> map = Thread.getAllStackTraces().keySet()
    .stream().collect(Collectors.groupingBy(Thread::getThreadGroup));


map.forEach((group,threadList) -> {
    System.out.println("Name: " + group.getName());
    threadList.forEach(thread -> 
        System.out.println("    Name: " + thread.getName() + ", id: " + thread.getId() 
            + ", State: " + thread.getState() + ", Is daemon? " + thread.isDaemon())
    );
});