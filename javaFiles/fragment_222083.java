static {
    if (isHeadless) {
        System.setProperty("testfx.robot", "glass");
        System.setProperty("testfx.headless", "true");
        System.setProperty("prism.order", "sw");
        System.setProperty("prism.text", "t2k");
        System.setProperty("java.awt.headless", "true");
    }

    try {
        ApplicationTest.launch(Main.class);
    } catch (Exception e) {
        // oh no
    }
}