public static void main(String[] args) {
    Robot robot = null;
    try {
        robot = new Robot();
    } catch (AWTException e) {
        e.printStackTrace();
    } catch (Throwable th) {
        th.printStackTrace();
    } 
}