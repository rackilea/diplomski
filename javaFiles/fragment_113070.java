public static void main(String[] args)
{
    int number = 0;
    for (int i = 0; i < 10; i = i + 1)
    {
        number = number + 1;
    }
    System.out.println("Main: " + number);
    print(number);
}

//We use the created variable as a parameter
public static void print(int number)
{
    System.out.println("Print: " + number);
}