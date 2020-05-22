private void addGuest(String string) 
 {

        if (Guest <= 3)
        {
            System.out.println(Guest + " cannot come to the party. The guest list is    full.");
        }
        else
        {
            guestList[Guest]=string; 
            Guest++;
         }
  }