while (!done) {

            System.out.println("Enter the winning number (20-50):");
            winningNumber = keyboard.nextInt();
            if (winningNumber >= 20 && winningNumber <= 50) {
                System.out.println("Awesome! Great number!");
                done = true;
            } else {
                System.out.println("This number is incorrect. Please enter a number between 20 and 50.");

            }

        }
         Guts g = new Guts();