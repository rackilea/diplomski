private static String browseFolder(String result, File folder) {
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            // here:
            result += browseFolder(result, fileEntry);
        }
        else {
            System.out.println(fileEntry.getPath());
            result += fileEntry.getPath() + "\n";
        }
    }
    return result;
}