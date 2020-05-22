System.out.println("Please enter fluids ID: ");
while (true) {
    try {
        f.setFluidID(input.next());
        break; // break out of the current loop
    } catch (InputMismatchException e) {
        System.out.println("Error! Please provide the right input.");
        input.next();
    }
}

System.out.println("Please enter fluids molecular weight: ");
while (true) {
    try {
        f.setMolecularWeight(input.nextDouble());
        break; // break out of the current loop
    } catch (InputMismatchException e) {
        System.out.println("Error! Please provide the right input.");
        input.next();
    }
}

System.out.println("Please enter fluids temperature: ");
while (true) {
    try {
        f.setTemperature(input.nextDouble());
        break; // break out of the current loop
    } catch (InputMismatchException e) {
        System.out.println("Error! Please provide the right input.");
        input.next();
    }
}