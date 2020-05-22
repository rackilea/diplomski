ObjectMapper mapper = new ObjectMapper();
Options o1 = new Options();
o1.setOption("option1");
Options o2 = new Options();
o2.setOption("option2");
Question question = new Question();
question.setOptions(Arrays.asList(o1, o2));
question.setQuestionText("sample question");
System.out.println(mapper.writeValueAsString(question));