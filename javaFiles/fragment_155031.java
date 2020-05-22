class EmailServlet extends HttpServlet {
    private ExecutorService emailSender;

    public void init() {
        emailSender = Executors.newFixedThreadPool(1);
    }

    public void destroy() {
        emailSender.shutdownNow();
    }

    public void doPost(...) {
        ...
        emailSender.execute(new Runnable() {public void run() {sendEmail();}});
    }
}