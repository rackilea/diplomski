public void run() {
    try {
        while (!stopped) {
            ...
        }
    } finally {
        //Run killAll to stop webdriver and the proxy
        killAll();
        System.out.println("Thread complete");
    }
}