CreateDummyGroups create = new CreateDummyGroups();
Map<ThreadGroup, List<Thread>> map = new LinkedHashMap<>();
for(Thread thread: Thread.getAllStackTraces().keySet()) {
    List<Thread> list = map.get(thread.getThreadGroup());
    if(list == null) {
        list = new ArrayList<>();
        map.put(thread.getThreadGroup(), list);
    }
    list.add(thread);
}


for(Map.Entry<ThreadGroup,List<Thread>> groupEntry: map.entrySet()) {
    System.out.println("Name: " + groupEntry.getKey().getName());
    for(Thread thread: groupEntry.getValue()) {
        System.out.println("    Name: " + thread.getName() + ", id: " + thread.getId() 
            + ", State: " + thread.getState() + ", Is daemon? " + thread.isDaemon());
    }
}