class RequestAccountInfoTask implements Runnable {

    private Account account;
    private Handler mHandler;
    public RequestAccountInfoTask(Account account) {
        this.account = account;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void run() {
        doRequestAccountInfo(account);
        //use the handler
    }
}