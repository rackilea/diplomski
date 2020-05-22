double sum = 0, num = 0;
int count = 0;
Scanner scan = new Scanner(System.in);
do {
    System.out.print("Enter any positive number, enter -1 to quit: ");
    num = scan.nextDouble();
    if (num != -1) {
        if (num <= 0) {
            System.out.println("Please enter a positive number.");
            continue;
        }
        sum += num;
        count++;
    }
} while (num != -1);
System.out.printf("Average is : %.2f/%d = %.2f%n", sum, count, sum / count);