public static void main(String args[]){
    boolean doLoop = true;
    while (doLoop) {
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                listBooks();
                break;
            case 3:
                doLoop = false;
                break;
            default:
                System.out.println("Please enter a valid choice");
        }
    }

}