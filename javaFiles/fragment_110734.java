//-----------------------------------------------------------------
   //  Returns true if the current face of the coin is heads.
   //-----------------------------------------------------------------
   public boolean isHeads ()
   {
      boolean result = locked();

            if (result == false)
            {
                System.out.println("The coin method is locked");

                return false; // <-- you need a return value here.
            }
            else
            {
                return (face == HEADS);
        }
   } // <---Error Here

   //-----------------------------------------------------------------
   //  Returns the current face of the coin as a string.
   //-----------------------------------------------------------------
  public String toString()
   {
      boolean result = locked();

            if (result == false)
            {
                System.out.println("The coin method is locked");

                return null; // <-- you need a return value here.
            }
            else
            {
                String faceName;

                if (face == HEADS)
                   faceName = "Heads";
                else
                   faceName = "Tails";


                return faceName;
        }
   }