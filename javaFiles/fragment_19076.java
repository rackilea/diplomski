int prevQuestion = -1;
int nextQuestion = -1;
while (continuing) {
  while (nextQuestion == prevQuestion) {
    nextQuestion = randomno.nextInt(questions.length);
  }
  prevQuestion = nextQuestion;
  // ask nextQuestion and prompt to see if we're continuing
}