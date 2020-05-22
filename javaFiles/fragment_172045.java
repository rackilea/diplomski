String libraries[] = {"name1","name2",...}
boolean success = false;
for(String library : libraries) {
  try{
    System.load(library);
    success = true;
    break;
  }
  catch(UnsatisfiedLinkError) {}
}
if(!success) {
   //Handle the failed all case
}