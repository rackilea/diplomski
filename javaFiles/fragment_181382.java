File newest = null
for(File f : new File(dir).listFiles()){
    if(newest == null || f.lastModified() > newest.lastModified()){
        newest = f;
    }
}