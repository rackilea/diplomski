static void combination(int... c) {
    for (int a : c) {
        robot.keyPress(a);
    }
    for (int i = c.length - 1; i >=0; i--) {
        robot.keyRelease(c[i]);
    }
}