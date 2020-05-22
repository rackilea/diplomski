public class MyFile
{
    MyObject[] metadata;
    MyObject[] track;

    public int check(String s)
    {
        if(s.substring(0,s.length()-1).equals("metadata")) return 0;
        if(s.equals("trackstart")) return 1;
        return 2;
    }
}