public class TwoSmall
{
    public static void main(String[] args)
    {
        int input;

        System.out.println("Enter you numbers: ");
        input = IO.readInt();
        int min = input;
        int min2 = input;

        while (input >= 0)
        {
            numInputsGreaterThan1 = true;
            if (input < min)
            {
                min2 = min;
                min = input;
            }
            else if (input < min2)
            {
                min2 = input;
            }
            input = IO.readInt();
        }

        System.out.println("The lowest number was " + min 
                         + " and the second lowest is " + min2);
     }
}