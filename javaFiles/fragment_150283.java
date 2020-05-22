public List<File> getFilesList(){
    File dirLoc = new File("C:\\Temp");
    List<File> validFilesList = new ArrayList<File>();
    File[] fileList;
    final int fileSizeLimit = 1024000; // Bytes
    try {
        // select all the files whose size <= 1Mb
        fileList = dirLoc.listFiles(new FilenameFilter() {
            public boolean accept(final File dirLoc, final String fileName) {
                return (new File(dirLoc + "\\" + fileName).length() <= fileSizeLimit);
            }
        });
        long sizeCtr = fileSizeLimit;
        for(File file : fileList){
            if(file.length() <= sizeCtr){
                validFilesList.add(file);
                sizeCtr = sizeCtr - file.length();
                if(sizeCtr <= 0){
                    break;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        validFilesList = new ArrayList<File>();
    } finally {
        fileList = null;
    }
    return validFilesList;
}