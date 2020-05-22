public class Party
{
   private static int maxGuests;
   private static int numGuests = 0;
   private static String[] guestNames;
   private static String hostName;

   public Party(int maxGuests, String hostName)
   {
      this.hostName = hostName;
      this.maxGuests = maxGuests;
      this.guestNames = new String[maxGuests + 1];
   }

   public static void addGuest(String guestName)
   {
      if(isOnList(guestName) == true)
      {
         System.out.println(guestName + " is already on the list");
      }
      else if(maxGuests < numGuests)
      {
         System.out.println(guestName + " could not be added because the party is full");
      }
      else if(isOnList(guestName) == false)
      {
        guestNames[numGuests] = guestName;
        numGuests++;
      }

   }

   public static boolean isOnList(String guestName)
   {
      boolean onList = false;
      for(int i = 0; i < guestNames.length; i++)
      {
         if(guestNames[i] != null && guestNames[i].length() <= 1)
         {
            onList = false;
         }
         else if(guestNames[i] != null && guestNames[i].compareTo(guestName) == 0)
         {
            onList = true;
         }      
      }
      return onList;
   }

   public static void printParty()
   {
      System.out.println("Guest list for " + hostName + "'s party: ");
      for(String name : guestNames)
      {
         System.out.println(name);
      }
   }

    public static void main(String[] args)
    {
        Party party = new Party(3, "David Beckham");
        Party.addGuest("Zinedine Zidane");
        Party.addGuest("Roberto Baggio");
        Party.addGuest("Johan Cruyff");
        Party.addGuest("Diego Maradona");
        Party.printParty();
    }
}