PreparedStatement pstat = con
    .prepareStatement("insert into student_info (firstname,lastname,gender) 
        values (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS); // omit id column
pstat.setString(1, txtFName.getText());
pstat.setString(2, txtLName.getText());
pstat.setString(3, gender);
int result = pstat.executeUpdate();
// now got fetch the generated id