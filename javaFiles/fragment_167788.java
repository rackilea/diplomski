static void combination(int... i) {
    for (int a : i) {
        robot.keyPress(a);
    }
    for (int a : i) {
        robot.keyRelease(a);
    }
}