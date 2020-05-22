Scanner sc = new Scanner(System.in);
try {
    sc.nextDouble();
} catch (InputMismatchException e) {
    System.out.println("Oops, something went wrong...");
    sc.nextLine();
    sc.nextDouble();
}