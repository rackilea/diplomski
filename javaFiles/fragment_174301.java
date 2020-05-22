//just call the checkChars method with 2 strings and it will check both strings to make sure
//that all the characters are contained in both strings.

public static void main(String args[]) {
         String test = "abc";
         String test1 = "abcaaabbc";
         System.out.println("" + checkChars(test, test1));
     }
     public static String checkChars(String string1, String string2)
     {
         boolean isContained = false;
         char[] char1 = string1.toCharArray();
         char[] char2 = string2.toCharArray();
         for(int i = 0; i < char1.length; i++)
         {
             isContained = false;
             for(int j = 0; j < char2.length; j++)
             {
                 if(char1[i] == char2[j])
                 {
                     isContained = true;
                     break;
                 }
             }
             if(isContained == false)
             {
                 break;
             }
         }
         if(isContained == true)
         {
             for(int i = 0; i < char2.length; i++)
             {
                 isContained = false;
                 for(int j = 0; j < char1.length; j++)
                 {
                     if(char2[i] == char1[j])
                     {
                         isContained = true;
                         break;
                     }
                 }
                 if(isContained == false)
                 {
                     break;
                 }
             }
         }
         if(isContained)
         {
            return "Both strings contain the same characters.";
         }
         else
         {
            return "The strings have different characters.";
         }
     }