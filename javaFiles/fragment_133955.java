void foo() {
    new ThreadStartingObject("I'm alive!");
}

class ThreadStartingObject {
    private String message;

    public void ThreadStartingObject(String msg) {
        this.message = msg;
        new Thread() {
            public void run() {
                try {Thread.sleep(10000);} catch (InterruptedException e) {}
                System.out.println(message);
            }
        }.start();
    }
}