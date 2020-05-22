interface A
{
    String X = "XYZ";
}

interface B
{
    String X = "ABC";
}

class C implements A, B
{
    public static void main(String[] args)
    {
        System.out.println(X); // Ambigous X
    }
}