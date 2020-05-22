while (keepGoing == true)
        {
            System.out.println("Next digit = (Type the digit)");
            additionValue = additionValue + scan.nextInt();
            System.out.println("Any more digits? Type y/n");
            String next = scan.next();
            if (next.matches("Y|y"))
            {
                keepGoing = true;
            }
            else if (next.matches("N|n"))
            {
                keepGoing = false;
            }
            else
            {
                System.out.println("Great, you broke it.");
                System.exit(1);
            }
        }