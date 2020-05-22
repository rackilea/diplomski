public void persist() throws IOException{

  FileOutputStream fos = null;
  ObjectOutputStream out = null;
  try{
   fos = new FileOutputStream(FILE_NAME); //assumes filename is a constant you've defined
   out = new ObjectOutputStream(fos);
   out.writeObject(time);
  }finally{
    out.close();
  }
}



protected static void initialize() throws IOException{
   FileInputStream fis = null;
   ObjectInputStream in = null;
   try{
     fis = new FileInputStream(FILE_NAME);
     in = new ObjectInputStream(fis);
     instance  = (PersistentTime)in.readObject();
   }finally{
     in.close();
   }
}