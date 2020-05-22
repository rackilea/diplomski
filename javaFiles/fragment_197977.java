System.out.print("Enter your age:");
for (;;) {
    try {
        age = in.nextInt();
        break;
    } catch (InputMismatchException imme) {}
    in.nextLine();
    System.out.println("Enter correct value for age:");
}