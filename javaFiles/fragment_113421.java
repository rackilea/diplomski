import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Main
{
    static int regexWork(String command) {

        int count =0;
        Pattern COMMAND_PATTERN = Pattern.compile("[a-z]{1}[a-z0-9:]*\\/[a-z0-9]*\\\\[a-z]+");
        Matcher matcher = COMMAND_PATTERN.matcher(command);
        //If matches returns 1
        while (matcher.find())
            count=1;

        return count;
    }


    // Finding all subsets of given set[]
    static void printSubsets(char set[])
    {
          int count =0;
          int n = set.length;
          // Pick starting point
    for (int len = 1; len <= n; len++) 
    {    
        // Pick ending point
        for (int i = 0; i <= n - len; i++) 
        {
            StringBuffer sb = new StringBuffer();
            //  Print characters from current
            // starting point to current ending
            // point.  
            int j = i + len - 1;            
            for (int k = i; k <= j; k++) 
                sb.append(set[k]+"");

            count+=Main.regexWork(sb.toString());
        }
    }

    System.out.println(count);

    }

    // Driver code
    public static void main(String[] args)
    {   

        String set ="abc:/b1c\\xy";  //Can be any string for which you are checking
        printSubsets(set.toCharArray()); //Passing char array
    }
}