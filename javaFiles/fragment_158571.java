Scanner scan = new Scanner(System.in);

int max = Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;
for (;;) { // never-ending loop
    System.out.print("Value: ");
    if (! scan.hasNextInt()) {
        System.out.println("** Invalid input **");
        scan.nextLine(); // discard invalid input
        continue; // loop back to prompt again
    }
    int value = scan.nextInt();
    if (value == -1) // termination number
        break;
    if (value < min)
        min = value;
    else if (value > max)
        max = value;
}
System.out.println("Min = " + min);
System.out.println("Max = " + max);