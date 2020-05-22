CreateDummyGroups create = new CreateDummyGroups();
Functionality func = new Functionality();
for(ThreadGroup tg: func.getAllThreadGroups()) {
    if(tg != null) {
        System.out.println("Name: " + tg.getName());
        for(Thread t: func.getThreadsOf(tg)) {
            if(t != null) {
                System.out.println("    Name: " + t.getName() + ", id: " + t.getId() 
                    + ", State: " + t.getState() + ", Is daemon? " + t.isDaemon());
            }
        }
    }
}