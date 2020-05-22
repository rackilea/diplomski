authenticity(3); // call the method passing 3 as max number of tries...

public static boolean authenticity(int tries) {
          if (tries > 0)
          {
           short pin = sc.nextShort();
           if (pin == 1234) {
               System.out.println("PIN is correct");
               System.out.println("Card is active for operation!");
               return true;
           } else {
               System.out.println("PIN isn't correct! You have " + tries +"effort(s)");
               return authenticity(--tries); 
           }
          } 
          return false;
      }