int guessInt = 0;
int guesses = 0; // this would track the count of guesses

while( guessInt != rand) {
  System.out.print( "Enter your guess: " );
  guessInt = input.nextInt();
  guesses++;

  if(guessInt > rand) {
    System.out.println("Guess lower");
    System.out.println();
  }
  if(guessInt < rand) {
   System.out.println("Guess higher");
   System.out.println();
  }
}

....
System.out.println("You took" + guesses + "guessess");
...