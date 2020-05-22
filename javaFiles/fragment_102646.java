private static StringBuilder browseFolder(StringBuilder result, File folder) {
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            browseFolder(result, fileEntry);
        }
        else {
            System.out.println(fileEntry.getPath());
            result.append(fileEntry.getPath()).append("\n");
        }
    }
    return result;
}