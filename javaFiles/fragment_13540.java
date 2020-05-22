try {
                    userInput = scanner.nextInt();
                    switch (userInput) {
                        case 1:
                            Mode_1.multiplyTwoInteger();
                            break;
                        case 2:
                            Mode_2.multiplyTwoSpecifiedValues();
                            break;
                        case 3:
                            System.out.println("\nYou quit application. Goodbye :)");
                            return;
                        default:
                            System.out.print("Not found! Choose again game mode: ");
                    }
                } catch (Exception InputMismatchException) {
                    scanner=new Scanner(System.in); // Reinitiate the scanner object or use scanner.nextLine() to read bad input.
                    System.out.print("Wrong input!\nChoose again:");
                }