public void getLineBreaker(String s, int b)
{
    for(int x=0; x<s.length(); x++){
        System.out.print(s.charAt(x));
        if((x+1)%b == 0)               //print a newline every n characters (where n is b)
            System.out.println();
    }
}