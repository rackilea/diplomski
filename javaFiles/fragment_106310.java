public static File[] getMatchingFiles(String workingDirectory,final long timestamp,final long threshold){
    File directoryWithFiles= new File(workingDirectory);

    return directoryWithFiles.listFiles(new FilenameFilter() { 
        public boolean accept(File dir, String filename){  
            File file=new File(dir+File.separator+filename);
            if(file.isFile()){
                if(file.lastModified()<=timestamp  && file.lastModified() >(timestamp-threshold)){
                    return true;
                }
            }
            return false;
        }
    } );
}