public class HouseOfCards 
{
    private static final String[] arr = new String[]{"Clubs","Spades","Hearts","Diamonds"};
    public static void main(String[] args)
    {
            for(int i=0;i<arr.length;i++)
            {
            System.out.println("Ace of "+arr[i]);
                for (int singles = 2; singles <= 9; singles++)
                { 
                   System.out.println(singles + " of "+arr[i]);
                }//end of for loop()
               System.out.println("Jack of "+arr[i]);
               System.out.println("Queen of "+arr[i]);
               System.out.println("King of "+arr[i]);
               System.out.println("Ace of "+arr[i]);
           }//end of if()
     }//end of method main() 
   }//end of class HouseOfCards