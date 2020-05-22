boolean hasError = true;
while (hasError) {
    try {
        System.out.println("Hello! Please enter how many Students you have in your class: ");
        classSize = in.nextInt();
        hasError = false;
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. please make sure you enter numbers ONLY! No symbols or letters.");
        // variable has error remains true
    }
}