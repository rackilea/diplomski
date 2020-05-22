static volatile boolean cleanedUp = false;
static final Object lock = new Object();

@BeforeClass
public static void setup() {
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        public void run() {
            MyTestClass.tearDown();
        }
    }
}

@AfterClass
public static void tearDown() {
    synchronized (lock) {
        if (cleanedUp) return;
        // do clean up
        cleanedUp = true; 
    }         
}