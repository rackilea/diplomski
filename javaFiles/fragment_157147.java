try{

    Example c = new Example();
    FileOutputStream fout = new FileOutputStream("YOURPATH");
    ObjectOutputStream oos = new ObjectOutputStream(fout);   
    oos.writeObject(c);
    oos.close();
    System.out.println("Done");

   }catch(Exception ex){
       ex.printStackTrace();
   }