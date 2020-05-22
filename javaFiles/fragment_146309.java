public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    int n=1;

    while (n >= 1) {
        System.out.print("Enter a non-negative integer (-1 to quit) : ");
        n = keyboard.nextInt();
        // Calculate the factorial for each number you take as the input
        int factorial = Factorial(n);
        System.out.println(n + "! = " + factorial);}

    if (n == 0) {
        System.out.print(n = 1); }

    if (n == -1) {
        System.out.print("Goodbye!"); }
}