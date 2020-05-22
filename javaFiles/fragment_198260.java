@PostMapping("/question")
public Question createQuestion(@RequestBody Question question) {
    Question savedQuestion = questionRepository.save(question);
    savedQuestion.getQuestionChoices().forEach(choice -> choice.setQuestion(null));

    return savedQuestion;
}

@GetMapping("/question")
public List<Question> getQuestions() {
    List<Question> questions questionRepository.findAll();
    questions.forEach(question -> {
        question.getQuestionChoices.forEach(choice -> choice.setQuestion(null));
    });

    return questions;
}