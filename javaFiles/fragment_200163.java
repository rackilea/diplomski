private static boolean canScramble(String s1, String s2){
    String temp = s1;
    boolean result = true;
    for(int i=0 ; i<s2.length() ; i++){
        char c = s2.charAt(i);
        if(temp.contains(String.valueOf(c))){
            temp = temp.replaceFirst(String.valueOf(c), "");
        }else{
            result = false;
            break;
        }
    }
    return result;
}