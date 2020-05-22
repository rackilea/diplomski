import java.util.*;

class Codechef
{

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] word = new char[100];
        word = s.toCharArray();
        int k = s.length()-1;
        int x ;

        for (int i=0;i<s.length();i++){
               if((i<k))
               {
                   for (x=0; x<i; x++)
                       System.out.print(" ");
                   System.out.print(word[i]);
                   for ( x=0; x<k-i-1; x++)
                       System.out.print(" ");
                   System.out.println(word[k]);
                   k--;

               }

               else if(i == k){
                   for ( x=0; x<i; x++)
                       System.out.print(" ");
                   System.out.println(word[k]);
                   k--;

               }
               else{
                   for(x = k; x >= 0 ; x--)
                       System.out.print(" ");
                   System.out.print(word[k]);
                   for (x=0; x<i-k-1; x++)
                       System.out.print(" ");
                   System.out.println(word[i]);
                   k--;

               }

            }

    }

}