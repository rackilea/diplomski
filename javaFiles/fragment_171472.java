File f = new File("TestDir");
try{
  if(f.mkdir())
    System.out.println("Directory Created");
  else
    System.out.println("Directory is not created");
}catch(Exception e){
  e.printStacktrace();
}