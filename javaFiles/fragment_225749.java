System.out.println("Deleting: " + dir.getCanonicalPath());
if (dir.isDirectory()) {
    File[] children = dir.listFiles();
    boolean success = true;
    for (File element : children) {
        if (!deleteDir(element, exclusionList)) {
            success = false;
        }
    }
    return success;   // <= for directories the method returns here
}

return dir.delete();