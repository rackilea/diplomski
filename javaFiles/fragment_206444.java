ExecutorService executorService = Executors.newFixedThreadPool(3);
MyWorker worker = new MyWorker(UserDao userDao);
executorService.submit(worker);

private class MyWorker implements Callable {
    private UserDao userDao 
    MyWorker(UserDao userDao){
        this.userDao = userDao;
    }

    public void call() {
        .. do something
    }
}