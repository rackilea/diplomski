public static boolean compare(char wrt){
    String str = "[^\\s\\w]";
    for(int i=0;i<str.length();i++){ //why are you diong this?
        if(str.charAt(i) == wrt) //you are checking every char of the regex agains the input char!
            return true;
    }
    return false;
}