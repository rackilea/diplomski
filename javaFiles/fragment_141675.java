final int localVar = 5;

new Runnable() {
    int innerVar = localVar;  // <--- initialized here

    public void run() {
        System.out.println(innerVar);
    }
}.run();