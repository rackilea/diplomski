for(int i=0; i<15; i++)
    {
        Question q = new Question();
        //makes sure there are no duplicates
        if(!questions.contains(q))
            questions.add(q); //not working for some reason cry
    }
    for (Question question : questions) {
        System.out.println(question.getQuestion());
    }