public void run(){

   try {
       while(computation.execute()){}
   }
   catch (Exception e){
        e.printStackTrace();
   }
}