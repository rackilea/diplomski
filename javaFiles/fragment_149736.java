public static void main(String[] args) throws InterruptedException {
    Scanner scan = new Scanner(System.in);

    System.out.println("hello, my name is Slash");
    System.out.println("What is your name?");
    String name = scan.nextLine();
    System.out.println("Hello " + name);
    Thread.sleep(1000);
    System.out.println("How old are you?");
    int age = scan.nextInt();
    if (age < 18) {
        System.out.println("ur young af");
    } else if (age == 21) {
        System.out.println("Shots, shots, shots");
    } else if (age == 69) {
        System.out.println("ohhh yea");
    }
    System.out.println("you to calculate any thing?");
    scan.nextLine(); // <-- nextInt leaves a trailing new line.
    String a = scan.nextLine();
    if (a.equalsIgnoreCase("yes")) { // <-- compare string for equality in
                                        // Java
        System.out.println("What would u like to do?(multiply,or add)");
        a = scan.nextLine();
        if (a.equalsIgnoreCase("add")) {// <-- compare string for equality
                                        // in Java
            System.out.println("Enter number 1");
            double num1 = scan.nextDouble();
            System.out.println("Enter number 2");
            double num2 = scan.nextDouble();
            double ans = num1 + num2;
            System.out.println(ans); // <-- display answer
        }
    }
}