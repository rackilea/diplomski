File dir1 = new File("C:\\Users\\i074924\\Desktop\\Test");
if(dir1.isDirectory()) {
    File[] content = dir1.listFiles();
    for(int i = 0; i < content.length; i++) {
        //move content[i]
    }
}