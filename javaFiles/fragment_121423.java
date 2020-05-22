class A {
    void functionX(List<YourClass> myList){
       ExecutorService exs = Executors.newFixedThreadPool("expected size of list");
        for( Runnable r : myList){
           exs. submit(r);
        }
    exs.shutdown();

    }
    Void functionY {
        while(condition) {
             functionX();
        }
    }
}