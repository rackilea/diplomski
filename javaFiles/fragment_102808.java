public static void setLibraryPath(String path) throws Exception {
    System.setProperty("java.library.path", path);

    //set sys_paths to null so that java.library.path will be reevalueted next time it is needed
    final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
    sysPathsField.setAccessible(true);
    sysPathsField.set(null, null);
}