class VerifyKeyword implements Runnable {

    WebDriver driver;
    VerifyPage verifyPage;
    private Thread thread;
    private List<String> keywords;
    private final Object LOCK;
    private volatile boolean exit = false;


    public VerifyKeyword(
            WebDriver driver, Logger logger, Object LOCK, List<String> keywords) {
        this.driver = driver;
        this.keywords = keywords;
        this.LOCK = LOCK;
    }

    @Override
    public void run() {

        VerifyPage verifyPage = new VerifyPage(driver);
        try {
            for (int i = 0; i < keywords.size(); i++){
                keyword = keywords.get(keywords.size() - 1);
                keywords.remove(keyword);
                verifyPage.verifyKeyword(keyword);
             }
          }     
        synchronized (LOCK) {
            LOCK.notify();
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, this.getClass().getName());
            thread.start();
        }
    }

    public void stop() {
        exit = true;
    }
}