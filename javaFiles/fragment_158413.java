for(int j = 1 + i; j < s.length() + 1; j++){
        String sub = s.substring(i, j);
        if(isPalindrome(sub) && sub.length() > str.length()){
            str = s.substring(i, j);
        }
}