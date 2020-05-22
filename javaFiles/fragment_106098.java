int correctAnswer = 0; // this is a new variable you have to introduce before  while (count < 5){

if (guess == answer){
    correctAnswer++;
}

// This line should be outside of while loop as well..
System.out.println("You got " + correctAnswer + " out of " + count + " questions correct");