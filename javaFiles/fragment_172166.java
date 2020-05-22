FileWriter writer = new FileWriter("src/dataNew/BelgiumNew1.csv", true);

try{
  // all your operations to handle the file
}

catch(Exception e){
  // your exception handling
}

finally{
   if (writer!=null){
      writer.flush();
      writer.close();
   }
}