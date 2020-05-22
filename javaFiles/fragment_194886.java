static boolean isPalindrome_1(String s){
    for(int i = 0 ; i < s.length() / 2 ; i++)
        if(s.charAt(i) != s.charAt(s.length() - i - 1))
            return isPalindrome(s , i + 1 , s.length() - i - 1) ||
                    isPalindrome(s , i , s.length() - i - 2);

     return true;
}

static boolean isPalindrome(String s , int lower , int upper){
    while(lower < upper){
        if(s.charAt(lower) != s.charAt(upper))
            return false;

        lower++;
        upper--;
    }

    return true;
}