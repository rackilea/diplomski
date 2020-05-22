FileInputStream fIn = null;
  try{

   char[] inputBuffer = new char[1024];
   String data = null;
   fIn = openFileInput(“public.dat”);

   return fIn;

}catch(IOException e){
  e.printStackTrace(System.err);

}