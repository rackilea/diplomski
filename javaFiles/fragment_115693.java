public static void main(String[] args) throws AWTException, InterruptedException {

    WebDriver driver = new FirefoxDriver();
    driver.get("http://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=7043856");

    // Added this line to let the page load completely
    String pageSource = driver.getPageSource();

    Robot robot = new Robot();

    // Press Ctrl+S
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_S);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_S);

    Thread.sleep(5000);

    // Generate a 2 digit random number and split it into two separate chars
    String random = RandomStringUtils.randomNumeric(2);
    System.out.println(random);
    char charOne = random.charAt(0);
    char charTwo = random.charAt(1);

    // Save As window has opened and the focus is on the file name field.
    // Click right arrow key to go to the last of the already present name
    robot.keyPress(KeyEvent.VK_RIGHT);
    robot.keyRelease(KeyEvent.VK_RIGHT);

    // Append the generated random number to the name
    robot.keyPress(getKeyEvent(charOne));
    robot.keyRelease(getKeyEvent(charOne));
    robot.keyPress(getKeyEvent(charTwo));
    robot.keyRelease(getKeyEvent(charTwo));

    Thread.sleep(5000);

    // Press enter
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);

}

public static int getKeyEvent(char key) {

    switch (key) {
    case '1':
        return KeyEvent.VK_1;
    case '2':
        return KeyEvent.VK_2;
    case '3':
        return KeyEvent.VK_3;
    case '4':
        return KeyEvent.VK_4;
    case '5':
        return KeyEvent.VK_5;
    case '6':
        return KeyEvent.VK_6;
    case '7':
        return KeyEvent.VK_7;
    case '8':
        return KeyEvent.VK_8;
    case '9':
        return KeyEvent.VK_9;
    default:
        return KeyEvent.VK_0;
    }
}