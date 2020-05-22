public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


  String filename = "playlist.dat";

   File f = new File(filename);

  try{

   ObjectOutput ObjOut = new ObjectOutputStream(new FileOutputStream(f));

     ObjOut.writeObject(//ur JList object);

     ObjOut.close();

     System.out.println("Serializing an Object Creation completed successfully.");

    }

catch(IOException e){

   System.out.println(e.getMessage());

      }

}