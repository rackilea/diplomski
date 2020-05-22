case "+":
                System.out.println ("Enter first number:");
                while(!scanner.hasNextInt())
                {
                    System.err.println("Enter valid int");
                    scanner.next();
                }

                num1 = scanner.nextInt();
                System.out.println ("Enter second number:");
                while(!scanner.hasNextInt())
                {
                    System.err.println("Enter valid int");
                    scanner.next();
                }

                num2 = scanner.nextInt();
                add(num1, num2);

                break;