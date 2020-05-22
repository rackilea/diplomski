private int getBookQuantity() {
    while (true) {
        try {
            System.out.println("Enter the book quantity");
            int q = s.nextInt();
            return q;           
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer.");  
            s.nextLine();
        }
    }
}