String toPalindrome(String str){
    StringBuilder reverse = new StringBuilder(str).reverse();

    for(int idx = 0; idx < str.size()/2; idx++)
        if(str.getCharAt(idx) < reverse.getCharAt(idx))
            reverse.setCharAt(idx, str.getCharAt(idx));

    return reverse.subString(0,str.size()/2) + reverse.reverse().subString(str.size()/2);
}