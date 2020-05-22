ObjectOutputStream oos = null;
 FileOutputStream fout = null;
 try{
        FileOutputStream fout = new FileOutputStream("Your file path");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(mb); // mb is an instance of MyBundle
 } catch (Exception ex) {
        e.printStackTrace();
 }finally {
   if(oos  != null){
     oos.close();
   } 
 }