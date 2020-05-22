public class calch 
{
    public static void main(String[] args) 
    {  
        int [] values = {3,4,6,3,4,5,10,7,4,5,3,10,4,9};
        for (int i =0; i < values.length; i ++)
        {
            // you can just use one "if" for checking "values[i]>9"
            // Added some checks so thta you wont get "IndexOutOfBoundsException"
            if((values[i] > 9) && (i>1) && (i<values.length-2))
            {
                double average = (double)(values[i-2]+values[i-1]+values[i]+values[i+1]+values[i+2])/5; 

                //System.out.println(average);  for debugging
                if (average > 9)
                    System.out.println("True changes  " + values[i]);
                else if (average < 9)
                    System.out.println("False Changes " + values[i]);
            }
            else
            {
                // ... I do't know what to do if data is not in correct form
                // that is if you last element of array is >9
            }
        }
    }
}