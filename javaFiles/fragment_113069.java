Private static int number;

public static void main(String[] args)
{
    //By removing `int`, we reference the variable that has already been initialized
    //instead of creating a new one
    number = 0;
    for (int i = 0; i < 10; i = i + 1)
    {
        number = number + 1;
    }
    System.out.println("Main: " + number);
    print();
}

public static void print()
{
    System.out.println("Print: " + number);
}