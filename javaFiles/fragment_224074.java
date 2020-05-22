public void findMatchingFiles(File f) {

    //i added this. you need to change it to be whatever extension you want to match
    String myExtension = ".exe";

    if (f.isFile() == true) {

        //i added this block. it gets the extension and checks if it matches
        int i = fileName.lastIndexOf('.');
        String extension = fileName.substring(i+1);
        if (extension.equals(myExtension)) {
            foundFiles.add(f.getPath());
        }
        return;
    } else {

        //i added this. it gets all the files in a folder
        for (File subFile : f.listFiles()) {
            findMatchingFiles(subFile);
        }
    }
}