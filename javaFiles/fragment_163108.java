for (int divisor = 2; divisor <= sum / 2; divisor++){

        if (sum % divisor == 0) { // If true, number is not prime
              isPrime = false; // Set isPrime to false
              System.out.println("The sum is not a prime number.");
              break;
        }
        else {
             System.out.println("The sum is a prime number.");
             break;
         }
}