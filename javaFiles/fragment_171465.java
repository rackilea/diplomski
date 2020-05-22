public List<Question> prepareRandomTest(int number_of_questions){ 
  String sql = "SELECT * FROM question ORDER BY RANDOM() LIMIT "+number_of_questions;
  SQLQuery query = session.createSQLQuery(sql);
  query.addEntity(Question.class);
  List<Question> results = (List<Question>)query.list();
  return result;
}