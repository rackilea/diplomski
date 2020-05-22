try{
//make File object
File testfolder=new File("C:/test");
//create folder
testfolder.mkdirs();
//make another file object
File Finialfile=new File("C:/test/finial.tbl"); 
//create file
Finialfile.createNewFile();
}catch(Exception e){
System.out.println(e.getMessage());
}