class MyCharacter {
   private Character c;
   private boolean isOriginal;

   public MyCharacter(Character c, boolean isOriginal) {
       this.c = c;
       this.isOriginal = isOriginal;
   }

   public Character getChar() {
       return c;
   }

   public boolean isOriginal() {
       return isOriginal;
   }
 }