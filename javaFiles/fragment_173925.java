try{

 fileReader = new FileReader(inputFileName);
 BufferedReader reader = new BufferedReader(fileReader);

}catch(IOException ex){
   //handle exception;
}finally{
   // close resources
}