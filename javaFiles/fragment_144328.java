public static String getFileType(String filePath){
    String fileType ="";
    int count=0;
    FileInputStream in=null;
    try{
        in =new FileInputStream(filePath);
        StringBuffer systemFormat = new StringBuffer();
        int i = 0;
        while((count=in.read())!=-1){
            //CR: ASCII: 13
            if(count == 13){
                systemFormat.append(String.valueOf(count));
                i++;
            }
            //LF: ASCII: 10
            if(count == 10){
                systemFormat.append(String.valueOf(count));
                i++;
            }
            if(i == 2) break;
        }
        if(systemFormat.toString().contains("1313")){
            fileType = "Mac";
            System.out.println("It's a Mac format file");
        }else if(systemFormat.toString().contains("1310")){
            fileType = "Windows";
            System.out.println("It's a Windows format file");
        }else if(systemFormat.toString().contains("1010")){
            fileType = "Unix";
            System.out.println("It's a Unix format file");
        }
    }catch(FileNotFoundException e) {
        util.LogWriter.log(e);
    }catch(IOException e) {
        util.LogWriter.log(e);
    }
    return fileType;
}