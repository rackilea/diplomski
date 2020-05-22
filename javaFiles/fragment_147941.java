public enum ModifierCode {

   LSHIFT(KeyCode.LeftShift),
   RSHIFT(KeyCode.RightSHift)  // bear with me, I dont have KeyCode enum in memory
   ; 

   final private KeyCode keyCode;

   private ModifierCode(KeyCode c) {
       this.keyCode = c;
   }

   public KeyCode getKeyCode() {  // maybe asKeyCode() would also be a nifty name :-)
        return keyCode;
   }

   public static ModifierCode fromKeyCode(KeyCode c) {
       for(ModifierCode m : values() ) {
            if( m.keyCode == c ) {
                return m;
            }
       }
       throw IllegalArgumentException("No MOdifierCode with that KeyCode!");
   }
}