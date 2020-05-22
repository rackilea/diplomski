CreateDummyGroups create = new CreateDummyGroups();
Functionality func = new Functionality();
ThreadGroup[] tg = func.getAllThreadGroups();
Thread[] t = func.getAllThreads();
for(int i=0; i<tg.length; i++) {
    if(tg[i] != null) {
        System.out.println("Name: " + tg[i].getName());
        for(int j=0; j<t.length; j++) {
            if(t[j] != null && t[j].getThreadGroup() == tg[i]) {
            System.out.println("    Name: " + t[j].getName() + ", id: " + t[j].getId() 
                    + ", State: " + t[j].getState() + ", Is daemon? " + t[j].isDaemon());
            }
        }
    }
}