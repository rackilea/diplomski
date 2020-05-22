enum Decisions{
         HIT, STAND, SURRENDER, QUIT, PLAY, NOTVALID;

         public static Decisions asDecision(String input) {
             for(Decisions d : values()) {
                 if(d.name().toLowerCase().equals(input.toLowerCase()) {
                     return d;
                 }
             }
             return Decisions.NOTVALID;
         }
    }