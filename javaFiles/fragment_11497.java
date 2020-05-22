Scanner input = new Scanner(System.in);
    int age;
    System.out.println("How old are you?");
    age = input.nextInt();
    // Added {} and removed ;
    if (age >= 20) {
        System.out.print("You Passed!");
    // Added curly brackets and removed boolean expression
    } else {
        System.out.println("You Failed!");
    }