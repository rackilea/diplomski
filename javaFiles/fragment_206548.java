File f = new File(filePathString);
if(f.exists() && !f.isDirectory()) { 
    // do something
} else {
    f.createNewFile();
}