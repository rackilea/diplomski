List<Thread> threads = new ArrayList<Thread>();

    threads.add(calculation1());
    threads.add(calculation2());

    for(Thread t : threads){
        if(t.isAlive()){
           t.join();
        }
    }