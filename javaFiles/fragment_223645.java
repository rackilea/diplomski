public static void doStuff() {

    Robot r = new Robot();

        r.delay(500); //Or more - depends on the game

        r.keyPress(KeyEvent.VK_Z);
        r.keyRelease(KeyEvent.VK_Z);

        r.keyPress(KeyEvent.VK_1);
        System.out.println("Press 1 button");
        r.keyRelease(KeyEvent.VK_1);
        System.out.println("Release 1 button");
        r.delay(1000);

        System.out.println("Move mouse");
        r.mouseMove(110, 690);

        System.out.println("Press");
        r.mousePress(InputEvent.BUTTON3_MASK);
        System.out.println("Release");
        r.mouseRelease(InputEvent.BUTTON3_MASK);
}