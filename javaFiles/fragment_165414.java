int num = 24, count=0;  // Initializing the first number to be 24, since it is divisible by both 8 and 4.
      while (num <=500)
      {
          System.out.print(num +","); 
          count++; // Incrementing the record count
          num +=8; // Adding 8 to the existing number
          if (count == 10)
          {
              System.out.println(""); // A new line after every tenth record
              count=1; // Count is reset here
          }
      }