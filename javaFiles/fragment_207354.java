public void run(){
   LocalTime timestamp = null;
   while((timestamp = data.take()) != null){
      ...
   }
}