// Display the officially correct answer from the arraylist
String correctAnswer =  myList.get(random1 +1); 
System.out.println("Answer: " + correctAnswer); // Instead use a variable

// if the user answer matches the official answer, tell them they're
// correct and award points
// else tell them they suck LOL
if(correctAnswer.equalIgnoreCase(answer)) { // efficient than contains() method
    System.out.println("Correct!");
    totalScore = totalScore + awardedPoints;
    System.out.println("You won " + awardedPoints);
}
else {
    System.out.println("You suckkkkkkk");
}