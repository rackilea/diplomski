try{
//make File object
File testfolder=new File(filePath);
//create folder
testfolder.mkdirs();
//make another file object
File Finialfile=new File(testfolder,"/finial.tbl"); 
//create file
Finialfile.createNewFile();
}catch(Exception e){
System.out.println(e.getMessage());
}