class CodepointReplacer
{

    public static void main(String[] args)
    {
        String str1 = "রেরেরে";
            /* 
             * The following is a linguistically invalid sequence,
             * but Java does not concern itself with linguistical correctness
             * if the String or char sequence has been constructed incorrectly.
             */
        String str2 = "েরেরের"; 
            /*
             * replacement character র for our strings
             * It is not রে as one would anticipate.
             */ 
        char c = str1.charAt(1);

        optimizeKookily(str1, c);
        optimizeKookily(str2, c);
    }

    private static void optimizeKookily(String temp, char c)
    {
        Integer length = temp.length();
        char[] charArray = temp.toCharArray();
        for (int u = 0; u < length; u++)
        {
            if (charArray[u] == c)
            {
                char g = charArray[u];
                charArray[u] = charArray[u - 1]; //throws exception on second invocation of this method.
                charArray[u - 1] = g;
            }
        }
    }
}