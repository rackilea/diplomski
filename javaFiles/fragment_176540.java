do {
            System.out.print("Please enter number");
            System.out.println(" ");
            newValue = input.nextInt();

            // See if value was already entered; search all array elements left of index i
            int ix = 0;
            while (ix < i && numList[ix] != newValue) {
                ix++;
            }
            // now either ix == i or numList[ix] == newValue;
            // if ix is not i, it means we encountered a duplicate left of index i
            invalid = ix < i;
            if (invalid) {
                System.out.println("That number was entered already, try again");
            } else if (newValue < 10 || newValue > 100) {
                System.out.println("Invalid number, please enter a number between 10 and 100");
                invalid = true;
            }
        } while (invalid);