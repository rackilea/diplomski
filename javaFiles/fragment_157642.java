public static void modify(int[] arr)
{
    arr[0] = 10;
}

public static void main(...) 
{
    int x = {1, 2, 3};
    System.out.println(x[0]); // prints 1

    modify(x);
    System.out.println(x[0]); // now it prints 10

}