class SomeClass {
   private long lastShot;

   public void userPressedShot() {
       if (System.currentTimeMillis()-lastShot>5000) {
            lastShot = System.currentTimeMillis();
            doTheRealShot(); 
       }       
       // Ignored till 5000 miliseconds from last shot
   }

}