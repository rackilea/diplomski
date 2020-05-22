Map<Question, Question> questions = new Hashmap<Question, Question>();
for (Answer answer : answers)
{
    if (questions.ContainsKey(answer.getQuestion()))
    {
        Question votingQuestion = questions.get(answer.getQuestion());
        if (votingQuestion.getPossibleAnswers().Count() < 4)
            votingQuestion.getPossibleAnswers().add(answer.Text);
    }
    else
    {
        Question votingQuestion = createVotingQuestion(answer.getQuestion());
        votingQuestion.getPossibleAnswers().add(answer.Text);
        questions.add(answer.getQuestion(), votingQuestion);
    }
}