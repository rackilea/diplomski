catch (InputMismatchException e) // outputs error message if value provided is not an integer
            {
                System.out.println("Incorrect input type.");
                // Moved the nextLine() method call over here
                scan.nextLine();
            }