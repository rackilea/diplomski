public class WordReverse 
{
    public static void main(String[] args)
    {
        String input = "The red hat belongs to John";
        String reverse = "";
        int lastSpace = 0;

        do
        {
            //Isolate Word w/ Preceding Space
            int startIndex = lastSpace;
            int endIndex = input.indexOf(' ', startIndex+1);
            if (endIndex==-1) {
                reverse = input.substring(startIndex) + reverse;
                break;
            }

            //Add Word to front of String 
            reverse = input.substring(startIndex, endIndex) + reverse;

            //Add Preceding Space for First Iteration
            if (lastSpace == 0) reverse = " " + reverse;

            //Reset Last Space
            lastSpace = endIndex;

            // Repeat Loop Until line14 .indexOf returns -1 due to lack of " ". 
        }while (true);

        System.out.println(reverse);
    }
}