public static void deleteDirectory(File directory) {
    if (directory.isDirectory())
        for (File child : directory.listFiles())
            deleteDirectory(child);

    directory.delete();
}