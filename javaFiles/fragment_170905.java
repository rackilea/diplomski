public List<File> getFilesToSend(String sourcePath, String pattern, String format) {

    List<File> files = new ArrayList<>();

    File[] clientDirs = getCustomerDirs(sourcePath);

    for (int i = 0; i < clientDirs.length; i++) {
        files.addAll(processClientDirectory(clientDirs[i], pattern, format));
    }

    return files;
}

private List<File> processClientDirectory(File clientDir, String pattern, String format) {

    List<File> result = new ArrayList<>();

    pattern = pattern.toLowerCase(Locale.ENGLISH);
    format = Constants.EXTENSION_SEPARATOR + format.toLowerCase(Locale.ENGLISH);

    File cobDir = new File(clientDir, "COB" + DateHelper.getPreviousWorkingDay());
    getFilesToProcess(result, cobDir, pattern, format);

    return result;
}

private void getFilesToProcess(List<File> result, File cobDir, String pattern, String format) {


    if (!cobDir.exists()) {
        return;
    }

    File[] files = cobDir.listFiles(pathName -> {
        if (pathName.isDirectory()) {
            return true;
        }

        if (!pathName.isFile()) {
            return false;
        }

        String name = pathName.getName().toLowerCase(Locale.ENGLISH);
        if (!name.startsWith(pattern)) {
            return false;
        }
        if (!name.endsWith(format)) {
            return false;
        }

        return true;
    });

    for (int i = 0; i < files.length; i++) {
        File current = files[i];
        if (current.isDirectory()) {
            getFilesToProcess(result, current, pattern, format);
            continue;
        }
        result.add(current);
    }
}


private File[] getCustomerDirs(String sourcePath) {
    File[] directories = new File(sourcePath).listFiles(File::isDirectory);
    return directories;
}