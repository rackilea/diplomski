public static void main(String[] args) throws FileNotFoundException {

    int input, n, reverse = 0;

    System.out.println("Enter an integer: ");
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    input = n;
    while( n != 0 )
    {
        reverse = reverse * 10;
        reverse = reverse + n%10;
        n = n/10;
    }

    System.out.println(input + " in reverse order is "+reverse);
}