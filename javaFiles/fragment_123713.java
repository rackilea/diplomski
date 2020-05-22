try{
     FileInputStream in = new FileInputStream(myFile);
     ObjectInputStream objin = new ObjectInputStream(in);
   }catch(FileNotFoundException e){ 
      e.printStackTrace();
   }catch(IOException e){
      e.printStackTrace();
   }