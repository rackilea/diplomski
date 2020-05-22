import java.util.Scanner;
import java.util.Arrays;
class StrSort
{
    public static void main(String args[])
    {
        int size;
        Scanner s=new Scanner(System.in);
        System.out.print("\nEnter the size of the array : ");
        size=s.nextInt();
        s.nextLine();  // Consume newline left-over
        String[] array=new String[size];
        int i;
        for(i=0;i<size;i++)
        {
            System.out.print("\nEnter string "+(i+1)+" : ");
            array[i]=s.nextLine();
        }
        Arrays.sort(array);
        System.out.print("\nStrings are sorted.");
        for(i=0;i<size;i++)
        {
            System.out.print("\nString "+(i+1)+" : "+array[i]);
        }
    }
}