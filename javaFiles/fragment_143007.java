Scanner input = new Scanner(System.in);
    System.out.println("Input numbers, 0 for stop!");
    int number = input.nextInt();
    double sum = 0;
    int counter = 0;
    while (number != 0) {
        sum += number;
        counter++;
        number = input.nextInt();
    }
    System.out.println("Average is: " + sum/counter);