class Palindrome {
    public static void main(String[] args) {
        Palindrome test1 = new Palindrome();
        String str = "Racecar";
        System.out.println("result: " + test1.isPalindrome(str.toLowerCase()));
    }

    public boolean isPalindrome(String s)
     {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end)
        {
         if (s.charAt(begin) != s.charAt(end))
         {
            return false;
         }
         begin++;
         end--;
        }
        return true; 
     }
}