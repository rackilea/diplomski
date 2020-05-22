public class Precedence 
{
    private static int a()
    {
        System.out.println("a");
        return 1;
    }   
    private static int b()
    {
        System.out.println("b");
        return 2;
    }
    private static int c()
    {
        System.out.println("c");
        return 3;
    }
    private static int d()
    {
        System.out.println("d");
        return 4;
    }
    private static int e()
    {
        System.out.println("e");
        return 5;
    }

    public static void main(String[] args) 
    {
        int x = a() + b() * c() / (d() - e());
        System.out.println(x);
    } 
}