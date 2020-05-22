for (Window w: allWindows) {
    //System.out.println(w.getClass().getSimpleName()+": "+w);
    try {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
    } catch (AWTException e) {
        e.printStackTrace();
    }
}