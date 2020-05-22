public static ProcessHandle.Info info(long pid, long startTime) {
    Info info = new Info();
    info.info0(pid);
    if (startTime != info.startTime) {
        info.command = null;
        info.arguments = null;
        info.startTime = -1L;
        info.totalTime = -1L;
        info.user = null;
    }
    return info;
}