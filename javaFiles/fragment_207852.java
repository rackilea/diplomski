List<Question> questions = database.getQuestions(1);
if(!questions.isEmpty())
{
 Question question = questions.get(0);
}else
{
 Log.e("LOG","questions  is Empty")
}