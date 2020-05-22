minSize = listUserAnswers.size() > listRealAnswers.size() ? listUserAnswers.size() : listRealAnswers.size();
for(int i = 0; i < minSize; i++)
  String userAnswer = listUserAnswers.get(i);
  String realAnswer = listRealAnswers.get(i);
  if(userAnswer.equals(realAnswer))
     ....