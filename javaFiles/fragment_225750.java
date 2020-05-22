System.out.println("Deleting: " + dir.getCanonicalPath());
if (dir.isDirectory()) {
    File[] children = dir.listFiles();
    boolean success = true;
    for (File element : children) {
        if (!deleteDir(element, exclusionList)) {
            success = false;
        }
    }

    // return only if some child couldn't be deleted.
    if(!success)
        return false;
}

// delete the directory itself (or the file, if a file is passed as parameter)
return dir.delete();