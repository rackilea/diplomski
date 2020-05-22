private int getInteger(String whatToEnter) {
    while (true) {
        try {
            System.out.println("Enter the " + whatToEnter);
            int q = s.nextInt();
            return q;           
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer.");  
            s.nextLine();
        }
    }
}