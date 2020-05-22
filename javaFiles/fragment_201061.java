try {
        fileFile = // exception thrown. Variable not assigned
} catch (URISyntaxException | NullPointerException e) {
        // exception caught
    }
    finally {
       // unassigned variable used here...
        if (fileFile.getPath()!= null){
            strPathName = fileFile.getPath();
        }
        if (fileFile.getName() != null){
            strFileName = fileFile.getName();
        }
    }