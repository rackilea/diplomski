System.out.print("Enter your age:");
try {
    age = in.nextInt();
} catch (InputMismatchException imme) {
    System.out.println("Enter correct value for age:");
    in.nextLine(); // get garbage input and discard it
    age = in.nextInt(); // now you can read fresh input
}