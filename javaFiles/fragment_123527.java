public static int foo(int x, int y) // x = 10, y = 5
{
    y = x + y; // 10 + 5 = 15, after this line y = 15, x = 10

    System.out.println(x + ", " + y); // prints 10, 15

    return (x + y); // return 25
}