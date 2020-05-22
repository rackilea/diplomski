File searchpath = new File(path);
File[] files = searchpath.listFiles();
if(files == null){
    // handle path not a directory, or other error
} else {
    for(File file: files){ ... }
}