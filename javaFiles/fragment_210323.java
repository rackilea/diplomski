int timh1 = 1;
int timh2 = 2;
PreparedStatement st = null;
String sqlGrammes = "SELECT SURNAME ,KATHGORIA, AFM , NAME FROM EMPLOYEE LIMIT ?,? ";
try {
    st = connection.prepareStatement(sqlGrammes);
    st.setInt(1, timh1); // notice the setInt
    st.setInt(2, timh2); // here too