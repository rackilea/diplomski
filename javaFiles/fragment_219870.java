CreateDummyGroups create = new CreateDummyGroups();
Functionality func = new Functionality();
ThreadGroup[] tg = func.getAllThreadGroups();
for(int i=0; i<tg.length; i++) {
    if(tg[i] != null) {
        System.out.println("Name: " + tg[i].getName());
        Thread[] t = func.getThreadsOf(tg[i]);
        for(int j=0; j<t.length; j++) {
            if(t[j] != null) {
            System.out.println("    Name: " + t[j].getName() + ", id: " + t[j].getId() 
                    + ", State: " + t[j].getState() + ", Is daemon? " + t[j].isDaemon());
            }
        }
    }
}