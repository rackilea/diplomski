public static boolean palTest(String str)
{
    if (str.length() < 2) return true;

    char first = str.charAt(0);
    char last = str.charAt(str.length() - 1);

    if (first != last){
        return false;
    } else{
        return palTest(str.substring(1, str.length()-1));
    }
}