package test;

public class CalcWordDiff {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "My name is ABC.";
        String b = "My name xyz.";
        System.out.println("Edit distance will be : "+calcDistanceBetweenWords(a,b));
    }

    public static int calcDistanceBetweenWords(String first, String second)
    {
        int res = 0;
        String[] words_string_first = first.trim().split(" "); // By trim, I removed the Whitespaces if they exist
        String[] words_string_second = second.trim().split(" ");
        //Check the length of both the arrays
        System.out.println("Size of arrays first is : "+words_string_first.length);
        System.out.println("Size of arrays second is : "+words_string_second.length);
        int lowerWordSentSize = 0;
        if(words_string_first.length<=words_string_second.length)
        {
            lowerWordSentSize = words_string_first.length;
        }
        else
        {
            lowerWordSentSize = words_string_second.length;
        }
        //Now iterate through the array of lower size
        for(int i = 0; i< lowerWordSentSize; i++)
        {
            if(words_string_first[i].equals(words_string_second[i]))
            {
                //Do nothing, it means both the words are same
            }
            else
            {
                System.out.println("Words mismatched at "+(i+1)+" th Position.");
                res = i; 
            }
        }
        return res;
    }

}