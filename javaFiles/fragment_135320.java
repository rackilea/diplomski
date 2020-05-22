public void setTires(Tires tires){
     if(!hasAxels()) {
         throw new IllegalStateException("no axels!");
     }
     mTires = tires;
     mHasTires = true;
 }