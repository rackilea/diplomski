PreparedStatement statement = conn.prepareStatement("INSERT INTO patientinfo"+
                                     "(firstName, lastName, DOB, age, SSN, address," +
                                     "phone,email, emergencycontact, emergencyphone)"+
                                     "VALUES(?,?,?,?,?,?,?,?,?,?)");
statement.setTimestamp(1,sqlDate);
statement.setString(1,firstTxt.getText());
statement.setString(2,lastTxt.getText());
statement.setDate(3,convertUtilDateToSqlDate(DOBTxt.getDate()));
statement.setString(4,ageTxt.getText());
statement.setString(5,ssnTxt.getText());
statement.setString(6,addressTxt.getText());
statement.setString(7,phoneTxt.getText());
statement.setString(8,emailTxt.getText());
statement.setString(9,emergencyTxt.getText());
statement.setString(10,emergPhoneTxt.getText());
int i = statement.executeUpdate();
if(i>0){
    System.out.println("Successfull");
 }