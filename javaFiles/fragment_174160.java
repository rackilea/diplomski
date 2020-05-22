public BigBoss(int strength, int scareFactor) {     
    this(strength, scareFactor, -1, false);
}       

//costructor with all required params to instantiate BigBoss properly  
public BigBoss(int strength, 
               int scareFactor, 
               int healthAid, 
               boolean hasInvisibleMode) {
   super(strength, scareFactor);     
   mHealthAid = healthAid;     
   mHasInvisibleMode = hasInvisibleMode;   
}