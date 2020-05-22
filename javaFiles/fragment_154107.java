try{
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_META);
    robot.delay(500);                    // 200~500
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_META);
} catch(java.awt.AWTException awte) {
    System.out.println("AWTException");
}