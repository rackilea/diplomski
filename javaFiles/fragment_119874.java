while (guess != theNumber) {
                    try {                       
                        System.out.println("Guess a number between 1 and 100:");
                        guess = scan.nextInt(); // Reads the number typed on the
                        // keyboard by the player
                        count++; // Plus 1 every time a number is entered
                        System.out.println("You entered " + guess + ".");
                        if (guess < theNumber) { // If number entered is smaller
                            System.out.println("The number is bigger" + ", try again!");
                            System.out.println("Number of tries: " + count);
                        } else if (guess > theNumber) { // If number entered is
                            // bigger
                            System.out.println("The number is smaller" + ", try again!");
                            System.out.println("Number of tries: " + count);
                        } else { // If both previous cases are false
                            System.out.println("Congratulations! You've found the number!");
                        }
                    } catch (Exception e) {
                        System.out.println("Incorrect entering! Please enter a number between 1 and 100.");
                        scan = new Scanner(System.in);
                    }
                }