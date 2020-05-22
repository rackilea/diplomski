public String getLineBreaker(String s, int b)
{
    String str = "";
    for(int x=0; x<s.length(); x++){
        str += s.charAt(x);
        if((x+1)%b == 0)    
                str += "\n";
    }
    return str;
}