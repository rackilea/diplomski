for(File f : listOfFiles) {
    if (f.isFile()) {
        // ...
    }           
    if(f.isDirectory()) {
        readDirectory(f);
    }
}