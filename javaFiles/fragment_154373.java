static FileAlterationMonitor monitor;

public static void runExample(boolean b) {
    if (b) {
        monitor = new FileAlterationMonitor();
    } else {
        if (monitor == null) return;
        monitor.stop();
    }
}