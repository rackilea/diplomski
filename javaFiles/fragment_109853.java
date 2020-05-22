public static void main(String[] args) {

    int number = 0;
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter number(s): ");
    while(scanner.hasNextInt()) {
        number = scanner.nextInt();
        System.out.println("Number was " + number);
    }   
}