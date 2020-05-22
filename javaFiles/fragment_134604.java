System.out.print("Enter value " + ii + ": ");
 int min = Get();
 int c = 0;
 for(int ii = 1, j = 0; j < copySel ; ii++, j++) { 

            // Prompt as follows
            System.out.print("Enter value " + ii + ": ");
            try {
                c = Get();
            }
            catch (InputMismatchException e) {
                // Display the following text in the event of an invalid input
                System.out.println("Invalid input!");
                ii--;
            } min = Math.min(min, c);   

            System.out.print("minimum is:"+ min);
    }