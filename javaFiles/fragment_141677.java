final int localVar = 5;

new Runnable() {
    int innerVar;

    // Initialization block executed upon construction of this class
    {
        System.out.println("Initializing an anonymous Runnable");
        innerVar = localVar;
    }

    public void run() {
        System.out.println(innerVar);
    }
}.run();