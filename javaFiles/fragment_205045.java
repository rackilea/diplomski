synchronized(object) {
   while(myResourceArrived) {//like URL data, JDBC data or something
       object.wait();
   }
   System.out.println("Completed.");
}