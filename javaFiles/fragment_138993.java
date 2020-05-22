public static boolean isValid(String a, String b){
    for(char c : b.toCharArray())
        if(!a.contains(""+c))
            return false;
    return true;
}