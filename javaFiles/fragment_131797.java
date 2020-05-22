import static java.lang.System.*;
import java.util.*;
public class bubble sort
{
    public static void main(String[] args)
    {
        int i,j,temp;
        Scanner input = new Scanner(in);
        int number_array[]=new int [5];
        int index_array[5] = {0, 1, 2, 3, 4};
        for(i=0;i<number_array.length;i++)
        {
            out.println("please input an integer");
            number_array[i]=input.nextInt();
        }
        for(i=0;i<number_array.length;i++)
        {
            for(j=0;j<number_array.length;j++)
            {
                if(number_array[i]>number_array[j])
                {
                    temp=number_array[i];
                    number_array[i]=number_array[j];
                    number_array[j]=temp;

                    temp=index_array[i];
                    index_array[i]=index_array[j];
                    index_array[j]=temp;
                }
            }
        }
           out.print(number_array[4]+" is the largest number with initial index "+index_array[4]);
           out.println(number_array[3]+" is the 2nd largest number with initial index "+index_array[3]);

    }
}