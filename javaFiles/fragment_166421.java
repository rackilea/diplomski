public static boolean isRoot(File file) {
    File[] roots = File.listRoots();

    for (File root : roots) {
        if (file.equals(root)) {
        return true;
        }
    }

    return false;
}