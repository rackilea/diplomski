class Example
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String[] name = { "a" , "b" , "c" , "d"};
        int n;
        n = 4 % name.length;
        System.out.println(" 4 % 4 is " + n + ": " + name[n]);
        n = 7 % name.length;
        System.out.println(" 7 % 4 is " + n + ": " + name[n]);
        n = 50 % name.length;
        System.out.println("50 % 4 is " + n + ": " + name[n]);
    }
}