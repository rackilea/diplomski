CSVReader reader = new CSVReader(new FileReader(FILE_PATH));

// number to do at same time
int concurrencyCount = 5;
ExecutorService executorService = Executors.newFixedThreadPool(concurrencyCount);
CompletionService<Boolean> completionService = new ExecutorCompletionService<Boolean>(executorService);
String[] nextLine;

// ensure we use a distinct WebDriver instance per thread
final LinkedBlockingQueue<WebDriver> webDrivers = new LinkedBlockingQueue<WebDriver>();
for (int i=0; i<concurrencyCount; i++) {
    webDrivers.offer(new ChromeDriver());
}
int count = 0;
while ((nextLine = reader.readNext()) != null) {
    final String [] line = nextLine;
    completionService.submit(new Callable<Boolean>() {
        public Boolean call() {
            try {
                // take a webdriver from the queue to use
                final WebDriver driver = webDrivers.take();
                driver.get("http://google.com/");
                driver.findElement(By.name("q")).click();
                driver.findElement(By.name("q")).clear();
                driver.findElement(By.name("q")).sendKeys(line[0] + " " + line[1]);
                System.out.println(line[1]);
                line[2] = driver.findElement(By.xpath(XPATH_TO_1ST)).getText();

                // put webdriver back on the queue
                webDrivers.offer(driver);
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
    });
    count++;
}

boolean errors = false;
while(count-- > 0) {
    Future<Boolean> resultFuture = completionService.take();
    try {
        Boolean result = resultFuture.get();
    } catch(Exception e) {
        e.printStackTrace();
        errors = true;
    }
}
System.out.println("done, errors=" + errors);
for (WebDriver webDriver : webDrivers) {
    webDriver.close();
}
executorService.shutdown();