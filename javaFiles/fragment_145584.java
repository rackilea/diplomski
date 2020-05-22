public Question getQuestion() {
random=new random();// this line added
int index = random.nextInt(questionList.size());
Question q = questionList.get(index);

return q;}