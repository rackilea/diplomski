public static void deleteFilesOlderThanNdays(int daysBack, String dirWay, org.apache.commons.logging.Log log) {

    File directory = new File(dirWay);
    if(directory.exists()){

        File[] listFiles = directory.listFiles();            
        long purgeTime = System.currentTimeMillis() - (daysBack * 24 * 60 * 60 * 1000);
        for(File listFile : listFiles) {
            if(listFile.lastModified() < purgeTime) {
                if(!listFile.delete()) {
                    System.err.println("Unable to delete file: " + listFile);
                }
            }
        }
    } else {
        log.warn("Files were not deleted, directory " + dirWay + " does'nt exist!");
    }
}