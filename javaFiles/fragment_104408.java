try {
    Robot r = new Robot();
    //there are other methods such as positioning mouse and mouseclicks etc.
    r.keyPress(java.awt.event.KeyEvent.VK_UP);
    r.keyRelease(java.awt.event.KeyEvent.VK_UP);
 } catch (AWTException e) {
    //Teleport penguins  
 }