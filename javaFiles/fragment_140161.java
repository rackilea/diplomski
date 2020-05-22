private static void invokeRobotInAWT(final Integer ... ke) throws InvocationTargetException, InterruptedException {
    EventQueue.invokeAndWait(new Runnable(){
        public void run() {
            for (int currentEvent : ke) {
                robot.keyPress(currentEvent);
            }
        };
    });
}

public static void Start(String path) throws AWTException, InterruptedException, FileNotFoundException, InvocationTargetException {
    try (Scanner input = new Scanner(new FileReader(path));) {
        Spambot keyboard = new Spambot();
        Random rand = new Random();
        invokeRobotInAWT(KeyEvent.VK_ALT);
        Thread.sleep(150);
        invokeRobotInAWT(KeyEvent.VK_TAB);
        Thread.sleep(150);
        invokeRobotInAWT(KeyEvent.VK_TAB, KeyEvent.VK_ALT);
        Thread.sleep(500);
        while (input.hasNextLine() && !stopped) {
            // @@@ Would need extra threading here?
            keyboard.type(input.nextLine());
            Thread.sleep(rand.nextInt(1500)+1000);
            invokeRobotInAWT(KeyEvent.VK_ENTER, KeyEvent.VK_ENTER);
        }
    } finally {
        // input closed by try-with-resources
    }
}