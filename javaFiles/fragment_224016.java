@RequestMapping(method=RequestMethod.GET)
    public String index(Model model){                
    Option optionA = new Option(1, "A");
    Option optionB = new Option(2, "B");
    Option optionC = new Option(3, "C");

    Map<Integer, Option> optionMap = new HashMap<Integer, Option>();
    optionMap.put(optionA.getOptionKey(),optionA);
    optionMap.put(optionB.getOptionKey(),optionB);
    optionMap.put(optionC.getOptionKey(),optionC);

    Question question1 = new Question("A Q", optionMap, 1);
    Question question2 = new Question("B Q", optionMap, 1);
    Question question3 = new Question("C Q", optionMap, 1);
    Map<Integer, Question> questionMap = new HashMap<Integer, Question>();
    questionMap.put(1, question1);
    questionMap.put(2, question2);
    questionMap.put(3, question3);

    model.addAttribute("questionsModel", new QuestionsModel(questionMap));

    return "index";
}