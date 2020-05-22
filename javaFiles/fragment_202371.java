// Create a new questionnaire
Questionnaire questionnaire = new Questionnaire("The awesome questionnaire");

// Create a question and add answers to it
Question question = new Question("How awesome is this questionnaire?");
question.add(new Answer("It's pretty awesome", false));
question.add(new Answer("It's really awesome", false));
question.add(new Answer("It's so awesome my mind blows off!", true));

// Add the question to the questionnaire
questionnaire.add(question);