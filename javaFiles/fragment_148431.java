Scanner sc = new Scanner(new File("D:\\f.txt"));
Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
Robot robot = new Robot();

TimeUnit.SECONDS.sleep(2); // Increase the initial sleep time if necessary.

while (sc.hasNextLine()) { // use hasNextLine() so you can get rid of the if block at the end of the code

    TimeUnit.SECONDS.sleep(1); // added another 1 second sleep
    String scan = sc.nextLine();
    scan = "@" + scan;
    System.out.println(scan);
    StringSelection sl = new StringSelection(scan);

    cb.setContents(sl, sl);

    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);

    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);

    robot.keyPress(KeyEvent.VK_SPACE);
    robot.keyRelease(KeyEvent.VK_SPACE);
}