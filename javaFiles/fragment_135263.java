PreparedStatement ps = null;
ResultSet rs = null;
boolean validUser = false;

try{
    ps = connection.prepareStatement("SELECT * from regid WHERE emp_id = ? AND password = ?");
    ps.setString(1, [user_id_input]);
    ps.setString(2, [user_pw_input]);
    rs = ps.executeQuery();

    validUser = rs.next();
}finally{
    //Release your resources
}

if(validUser){
    //user is validated
}