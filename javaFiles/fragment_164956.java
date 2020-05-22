public abstract class Cell{

   private boolean isStricken = false;

   public void draw(){
       if(isStricken){
           drawStricken();
       }else{
           drawNotStricken();
       }
   }

   public boolen strike(){
       isStricken = true;
       return isItHit();
   }

   protected abstract void drawNotStricken();
   protected abstract void drawStricken();
   protected abstract boolean isItHit();
}