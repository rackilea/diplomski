// this is an list of questions. It's empty initially
// this list isn't meant to contain Strings, and it can't. 
// It will contain one Question object for each row in the table.
List<Question> questions = new ArrayList<Question>();
try{            
    Statement st = DBConnection.DBConnection.DBConnect();
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()){
        // this block is executed for each row in the table. 
        // Each row is transformed into a Question object

        Question question = new Question();
        question.setLabel((rs.getString("ques_name"));
        question.setOption1(rs.getString(3));
        question.setOption2(rs.getString(4));
        question.setOption3(rs.getString(5));
        question.setOption4(rs.getString(6));
        question.setAnswer(rs.getString(7));

        // now that we have created a Question object and populated it with the
        // cells of the row, we will add it to the list of questions:

        questions.add(question);
    }

    // So now, we have a list of questions. Each element of the list is an object
    // of type Question, which has a property label, a property option1, etc.
    request.setAttribute("questions", questions);
 }