public enum PlayerState {

    STATIC_STILL, STATIC_UP, STATIC_DOWN, MOVING_LEFT, MOVING_RIGHT;

    public boolean isMoving() {
         if(this == MOVING_LEFT || 
               this == MOVING_LEFT){
           return true;
         }
         return false;
    }
    public boolean isStatic() {
        if(this == STATIC_STILL || 
               this == STATIC_UP || 
               this = STATIC_DOWN){
           return true;
         }
         return false;
    }

}