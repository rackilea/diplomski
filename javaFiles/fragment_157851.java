public static void choosePath() {
    xyObj xyPos = actionClass.cmdCenter(cmdIF, x, y);
    System.out.println(xyPos.getX());
    System.out.println(xyPos.getY());
    x = xyPos.getX();
    y = xyPos.getX();
}