static boolean isPalindrome(String word){
        word=word.toLowerCase();  //Added this
        int c=word.length()-1;
        boolean flag = false;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)==word.charAt(c))
                flag=true;
            else
                return false;
            c--;
        }
        return flag;
    }