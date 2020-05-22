// Java
class Test {
    public static void main(String[] args) {
        long x = Long.MAX_VALUE - 1;
        double d = x;
        long y = (long) d;
        System.out.println(x == y);
    }
}

// C#
using System;

class Test
{
    static void Main()
    {
        long x = long.MaxValue;
        double d = x;
        long y = (long) d;
        Console.WriteLine(x == y);
    }
}