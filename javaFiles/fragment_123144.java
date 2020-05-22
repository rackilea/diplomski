public static void main(String[] args) {
    salarisdoel(100);
}

public static void salarisdoel(double targetAmount) {
    Scanner scanner= new Scanner(System.in);

    double total = 0;

    while (scanner.hasNextDouble()) {
        double inputMoney= scanner.nextDouble();
        total += inputMoney;
    }


    String input = scanner.next();
    System.out.println(input);//print to check what was read from the console
    switch (input) {
        case "I Quit!":
            System.out.println("Quitter");
            break;
        case "Ready":
            if (total>= targetAmount) {
                System.out.println("Congratulations");
            } else {
                System.out.println("Calculation Error");
            }
            break;
        default: 
            System.out.println("Something went wrong. Try again!");
            break;
    }     
}