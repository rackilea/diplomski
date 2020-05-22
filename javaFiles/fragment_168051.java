public void doStuff() {
   //do some stuff for which you do not require synchronization
   synchronized(this) {
     System.out.println("synchronized");
     // perform stuff for which you require synchronization
   }
}