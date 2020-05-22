@PostMapping("/question")
public QuestionDTO createQuestion(@RequestBody Question question) {
    Question savedQuestion = questionRepository.save(question);

    List<QuestionChoiceDTO> questionChoices = new ArrayList<>();
    savedQuestion.getQuestionChoices().forEach(choice -> {
        questionChoices.add(new QuestionChoiceDTO(choice.getId(), choice.getChoice()));
    });

    QuestionDTO response = new QuestionDTO(savedQuestion.getQuestion_id(), savedQuestion.getQuestionName(), savedQuestion.getQuestionText(), questionChoices);

    return response;
}

@GetMapping("/question")
public List<QuestionDTO> getQuestions() {
    List<Question> questions = questionRepository.findAll();
    List<QuestionDTO> response = new ArrayList<>();

    questions.forEach(question -> {
        List<QuestionChoicesDTO> questionChoices = new ArrayList<>();
        question.getQuestionChoices().forEach(choice -> questionChoices.add(new QuestionChoiceDTO(choice.getId(), choice.getChoice()));

        responses.add(new QuestionDTO(savedQuestion.getQuestion_id(), savedQuestion.getQuestionName(), savedQuestion.getQuestionText(), questionChoices));
    });
}