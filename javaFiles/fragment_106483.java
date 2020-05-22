protected File[] listEligibleFiles(File directory)
            throws IllegalArgumentException {

        File[] rootFiles = directory.listFiles();
        List<File> files = new ArrayList<File>(rootFiles.length);
        if ( rootFiles != null ) {
            files.add(rootFiles[0]);
        }
        return files.toArray(new File[files.size()]);
    }