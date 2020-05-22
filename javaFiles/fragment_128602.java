for (int row = 0; row < array.length; row++) {
        for (int column = 0; column < array[row].length; column++) {
            bool hasEnteredValidInput = false;
            do
            {
               int number = input.nextInt();
               if(number  >= 0) {
                  array[row][column] = number;
                  hasEnteredValidInput = true
               } else {
                  System.out.println("Input must be > 0.");
               }
            } while (!hasEnteredValidInput);
        }
    }