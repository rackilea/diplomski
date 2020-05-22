Set<Answer> answersSet = new HashSet<Answer>();
List<ToughQuiz> differentAnswers = new ArrayList<ToughQuiz>();
for(ToughQuiz quiz : animalQuizCollection){
    if(answersSet.add(quiz.getAnswer())){
        differentAnswers.add(quiz);
    }
    if(differentAnswers.size() >= 5) break;
}