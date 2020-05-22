Scanner scanner = new Scanner(System.in);
    int counter = 0;

    System.out.println("\nPerfect Number Finder Program");

    System.out.print("\nEnter the start value: ");
    int starval = scanner.nextInt();
    System.out.print("Enter the end value:");
    int endval = scanner.nextInt();

    for (int n1 = starval; n1 <= endval; n1++) {
        int sum = 0;
        for (int n2 = 1; n2 < n1; n2++) {
            if (n1 % n2 == 0) {
                sum = sum + n2;
            }
        }

        if (sum == n1) {
            System.out.println(n1 + " is a perfect number");
             counter ++; //This will add one to the counter if this loop is enterd
            }
         if(n1 == endval){
            System.out.println("FINISHED!");
            break;
         }
    }
    //If the counter is 0 then it will display the message
    if(counter == 0){
        System.out.println("THERE IS NO PERFECT NUMBERS");
    }
}