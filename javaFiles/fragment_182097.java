Program p1 = new Program();
    new Thread(p1).start(); // this thread and the next thread share the same Runnable instance 
   // So, they share the instance level fields also. Thus either one of them can change the state of p1 
    new Thread(p1).start();
    //we can also use

    (new Thread(new Program())).start();
    // This one creates a new instance of Program/ Runnable, thus does not share the same object.