public static String expand (String word)
{
    int stringLength = word.length();

    for (int x=1; x<(stringLength-1)*2; x+=2){
       word = new StringBuffer(word).insert(x, "-").toString();
    }
    return word;
}