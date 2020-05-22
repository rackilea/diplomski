public static String method4(String word){
    int length = word.length();
    if (length == 0){
         return "";
    }
    String last = word.substring(length-1, length);
    return  last + last + last +  method4(word.substring(0, length-1));
}