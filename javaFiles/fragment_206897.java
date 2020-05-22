File directory = new File(fileLoc);
FileFilter filter = new FileFilter() {
    public boolean accept(File file) {
        if (!file.isFile()) return false;
        LocalDateTime dt = new LocalDateTime(file.lastModified());
        if (dt!=null && (interval.contains(dt.toDateTime()) || interval.getEnd().isEqual(dt.toDateTime())))
            if (file.getName().startsWith(filePrefix))
                return true;
        return false;
    }};
File[] myFiles = directory.listFiles(filter);
if(myFiles.length < 1) {System.out.println("No files found");return;}
for (File file:myFiles) {
    try{
        System.out.println(readFileAsString(file));
    }catch(Exception e){}
}