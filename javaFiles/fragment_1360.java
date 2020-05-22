Set<Question> questions = new TreeSet<>();
    for(int i=0; i<15; i++)
    {
        questions.add(new Question());
    }
    for (Question question : questions) {
        System.out.println(question.getQuestion());
    }