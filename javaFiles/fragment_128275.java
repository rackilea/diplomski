import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        int i = 0;
        int j = 0;
        int k = 0;
        double temp = 0;
        double[] intValue = new double[10];
        String[] numbers = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth"};
        int len = intValue.length;

        BufferedReader dataIn = new BufferedReader (new InputStreamReader(System.in));

        for (i = 0; i < len; ++i) {
            System.out.println("Enter the " + numbers[i] + " number");
            intValue[i] = Double.valueOf(dataIn.readLine());
        }


        for (j = 0; j < len; j++)
        {
            for(k = 0; k < len; k++) {
                if (intValue[j] > intValue[k]) 
                {
                    temp = intValue[j];
                    intValue[j] = intValue[k];
                    intValue[k] = temp;
                }
            }
        }

        System.out.println("Array after sorting in ascending order");
        for (i = 0; i < 10; i++)
        {
            System.out.print(intValue[i] + ", ");

        }

    }
}