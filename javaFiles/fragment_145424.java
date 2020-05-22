public static String getLineBreaker(String s, int b)
{
    StringBuilder str = new StringBuilder();
    for(int x=0; x<s.length(); x++){
        str.append(s.charAt(x));
        if((x+1)%b == 0)    
                str.append("\n");
    }
    return str.toString();
}