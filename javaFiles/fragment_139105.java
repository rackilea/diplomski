public String execute(){
  myQuestions = new ArrayList<Question>();
  myQuestions.add(new Question("Question1", "ans1", "ans2","ans3"));
  myQuestions.add(new Question("Question2","ans1", "ans2","ans3"));

  //test results, map should not be empty
  map.put("Question1", "ans1");
  map.put("Question2", "ans2");
  session.put("map", map);