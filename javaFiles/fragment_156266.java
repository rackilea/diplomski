public class Chapter3
{
public static void main(String[] args) {
    excercise1();
    excercise2();
    ..........
}
public void excercise1()
{
    printNumbers(15);
    System.out.println();
    printNumbers(5);

}

public static void printNumbers(int x)
{

    for (int i = 1; i <= x; i++)
    {
        System.out.print(("[") + (i) + ("]") + (" "));
    }

}

public void excercise2()
{
    System.out.print(largerAbsVal(11, 2));
    System.out.println();
    System.out.print(largerAbsVal(4, -5));
}

public static int largerAbsVal(int x, int y)
{
    return Math.max(Math.abs(x), Math.abs(y));

}
 .................
}