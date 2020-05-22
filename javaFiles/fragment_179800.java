public static isEmptyFile(String fileName) {
    File file = new File(fileName);
    if (!file.exists()) {
        return false;
    } else if (file.length() != 0L) {
        return false;
    } else if (file.isFile()) {
        return true;
    } else if (file.isDirectory()) {
        return false;
    } else {
        // It may be impossible to tell that a device file / named pipe is
        // "empty" without actually reading it.  This is not a failing of
        // Java: it is a logical consequence of the way that certain
        // devices, etc work.
        throw new CannotAnswerException(...);
    }
}