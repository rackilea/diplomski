boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter your lottery pick (0-9): ");

            int guess1 = -1;
            try {
                guess1 = input.nextInt();
            } catch (Exception e) {
                // Read any pending input which would be invalid characters at this point
                input.next();
            }

            if (guess1 > 9 || guess1 < 0) {
                System.out.println("Wrong input enter only 1 number between 0-9: ");
            } else {
                isValid = true;
            }
        }