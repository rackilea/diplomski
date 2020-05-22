int i = numbers.length-1, count = 0; // Assuming you've an array of int[] say numbers
    while ( i > = 0 && num > numbers[i]) { // num is the value which is entered by a user.
          count = num / numbers[i];
          num %= numbers[i];
          if (num <= numbers[i]) {
              System.out.println ("You'll get " + numbers[i] + "for " + count + " times");
              count = 0;
              i--;
          }
    }
    System.out.println ("The left value is: " + num); // This will print the remaining value, which is smaller than the smallest value of array.