import java.io.*;
public class SelectReverse
{
public static void main(String args[]) throws IOException
{
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the string to be selectively reversed");
    String str = buf.readLine(); 
    str = str.trim();
    str = " ".concat(str);
    int len = str.length();    //length of first input string
    System.out.println("Enter the words to be left intact during reversal");
    String s = buf.readLine();
    int l = s.length();     //length of second input string
    int j = 0;
    int k = len-1;         //stores index upto which substring is extracted
    int wordcount = 1;
    String result = "";    //stores output string
    for(int i = 0; i<l; i++)        //counts no. of words which are not to be reversed
    {
        if(s.charAt(i) == ',')                                          
        {
            wordcount++;
        }
    }
    String arr[] = new String[wordcount];   //array of words not to be reversed
    int counter = 0;
    for(int i = 0; i<l; i++)                                        
    {
        if(s.charAt(i) == ',')
        {
            String subs = s.substring(j, i); //extracting individual words from list of words not to be reversed
            arr[counter] = subs;    //adding them in the array
            j = i+1;
            counter++;
        }
    }
    arr[counter] = s.substring(j);  //adding last word (after the last comma)
    boolean firstflag = false;
    for(int i = len-1; i>=0; i--)
    {        
        String substr;
        if(str.charAt(i)==' ' || str.charAt(i)=='.')
        {
            if(firstflag == false)  //substring is extracted till end of string only for the first extracted word
            {
                substr = str.substring(i+1);
                firstflag = true;
                k = i;
            }
            else
            {
                substr = str.substring(i+1, k);
                k = i;
            }        
            boolean flag = false;
            for(int m = 0; m<wordcount; m++)
            {
                if(arr[m].equalsIgnoreCase(substr))//true if substring is not to be reversed, i.e. matches with any word in array
                {                
                    flag = true;
                }
            }
            if(flag == true) //concatenating substring to output string without reversing
            {
                result = result+substr;
                result = result+" ";
            }
            else   //concatenating substring to output string after reversing
            {
                String reverse = "";
                int ln = substr.length();
                for(int n = ln-1; n>=0; n--)    //reversing substring
                {
                    char ch = substr.charAt(n);
                    String chstring = Character.toString(ch);
                    reverse = reverse+chstring;
                }
                result = result+reverse;
                result = result+" ";
            }        
        }
    }    
    System.out.println(result); //displaying resultant output string
  } 
}