new Thread(() -> {
    try {
        Thread.sleep(i);
    } catch (InterruptedException e) {
        System.out.println(e.getMessage());
    }
    Process process;
    try {
        process = Runtime.getRuntime().exec("shutdown -s -t 0");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}).start();