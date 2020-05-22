List<Answer> possibleAnswers = readThoseFromTheDatabase();
List<Answer> correctAnswers = doAFilterOn(possibleAnswers);

List<Answer> userAnswers = new List();
if (checkbox1.isSelected()) userAnswers.add(possibleAnswers.get(0));
if (checkbox2.isSelected()) userAnswers.add(possibleAnswers.get(1));
if (checkbox3.isSelected()) userAnswers.add(possibleAnswers.get(2));
if (checkbox4.isSelected()) userAnswers.add(possibleAnswers.get(3));