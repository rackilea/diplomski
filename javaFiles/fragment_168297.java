import java.util.Arrays;
import java.util.HashSet;

public class Main
{
    public static void main(String[] args) throws Exception
    {

        String[] input = {"a", "b", "a", "c", "b", "c", "d", "e", "f"};

        String[] output = new String[input.length];
        int count = 0;

        // Iterate over the input array
        for (String in : input)
        {
            // Check if the string is already in the output array
            boolean found=false;
            for (String out : output)
            {
                if (in.equals(out))
                {
                    found=true;
                    break; // break the inner for loop, no need to continue the search
                }
            }

            if (!found)
            {
                output[count++]=in;
            }
        }

        System.out.println(Arrays.toString(output));
    }
}