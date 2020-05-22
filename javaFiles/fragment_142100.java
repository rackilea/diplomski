ObjectInputStream objectinputstream = null;
 try {
        streamIn = new FileInputStream("Your file address");
        objectinputstream = new ObjectInputStream(streamIn);
        MyBundle mb = (MyBundle) objectinputstream.readObject();

   } catch (Exception e) {
        e.printStackTrace();
   }finally {
     if(objectinputstream != null){
        objectinputstream .close();
     } 
   }