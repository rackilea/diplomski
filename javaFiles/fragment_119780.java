public static void main(String [] args){
    Scanner console = new Scanner(System.in);
    System.out.println("Enter an integer: ");
    int n = console.nextInt();
    if(n>1) {
        System.out.println("The Fibonacci numbers less than " + n + " are: ");
        System.out.print("1, 1, ");
        int f2=1;
        int fibonacci=1;
        for(int i=1; i+f2 < n;){
            fibonacci = i + f2;
            i = f2;
            f2 = fibonacci;
            System.out.print(fibonacci+", ");
        }
    } else {
        System.out.println("There are no numbers less than " + n + " in the series");
    }
}