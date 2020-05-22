public static void main(String[] args) {
    boolean checkValue = false;
    int input;

    Scanner console = new Scanner(System.in);
    while (!checkValue) {

        System.out.println("Enter 1, 2 or 3");      

        // Check if we have an integer
        if (console.hasNextInt()) {
            input = console.nextInt();

            switch (input) {
            case 1:
                // code 
                checkValue = true;
                break;
            case 2:
                // code 
                checkValue = true;
                break;
            case 3:
                // code 
                checkValue =  true;
                break;

            default: // when entered a wrong number
                System.err.println("Wrong Input"); 
                checkValue = false;
            }
        }
        else {
            // when entered a character
            System.err.println("Wrong Input");
            // Consume the wrong input.
            console.next();
            checkValue = false;
        }
    }
}