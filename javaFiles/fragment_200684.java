Robot r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_SHIFT);
r.keyPress(KeyEvent.VK_F1);
r.keyRelease(KeyEvent.VK_F1);
r.keyRelease(KeyEvent.VK_SHIFT);
r.keyRelease(KeyEvent.VK_CONTROL);