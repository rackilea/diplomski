Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
for(Thread t:threadArray) {
    if(t.getName().contains("Abandoned connection cleanup thread")) {
        synchronized(t) {
            t.stop(); //don't complain, it works
        }
    }
}