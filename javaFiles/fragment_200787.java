enum Decisions{
     HIT, STAND, SURRENDER, QUIT, PLAY, NOTVALID;

     public static Decisions asDecision(String input) {
         try {
             return Decisions.valueOf(input);
         } catch(IllegalArgumentException e) {
             return Decisions.NOTVALID;
         }
     }
}