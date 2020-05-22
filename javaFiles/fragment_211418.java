String correctAnswer = answers.get(count).toLowerCase();
if(correctAnswer.contains(answer.toLowerCase()))
{
    System.out.println("Correct! + 1 point.");
    points += 1;
}