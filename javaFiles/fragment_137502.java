public ClassType chooseSpec(List<Question> questions, Scanner in) {

     List<ClassType> selectedAnswers = new ArrayList<>(questions.size());
      // iterate over all your questions
    for(Question question: questions) {
        // print question and all answers
        System.out.println(question.getQuestion() + "\n"
                + question.getAnswers().stream().map(Answer::getQuestion)
                .collect(Collectors.joining("\n")));

        int choice = in.nextInt();
        if(choice >= question.getAnswers().size()){
          // check if answer is within the scope
          throw IllegalArgumentException("There are only "+question.getAnswers() +" answers");
        }
        // add selected answer type to global result list 
        selectedAnswers.add(question.getAnswers().get(choice-1).getClassType());
    }

    return findMostPolularClass(selectedAnswers);
}

private ClassType findMostPolularClass(List<ClassType> selectedAnswers){
    // might be too fancy, but it will find most frequent answer
    Map<ClassType, Long> occurences = selectedAnswers.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    return occurences.entrySet().stream()
            .max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
 }