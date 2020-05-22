for(Thread t: Thread.getAllStackTraces().keySet())
    if (t.getName().equals("Finalizer")) {
        System.out.println(t);
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t);
    }