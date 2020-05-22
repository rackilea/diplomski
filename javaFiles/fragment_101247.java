public ResultSet execute(String sqlCommand ){

    ResultSet rs = null;

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankaccount", "root", "password");

        Statement st = (Statement) con.createStatement();
        PreparedStatement ps;


        rs = st.executeQuery(sqlCommand);


    } catch (Exception e) {
    }

    return rs;

}


public void submitButton1(){
     String login = jLogin.getText();
    String pin = jPin.getText();

ResultSet rs = execute("SELECT * FROM accounts WHERE loginID= '" + login + "' AND pin='" + pin + "'");

   /// do whatever with your rs

}

public void submitButton2(){
     String login = jLogin.getText();
    String pin = jPin.getText();

ResultSet rs = execute("more sql");

   /// do whatever with your rs

}