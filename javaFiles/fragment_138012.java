PreparedStatement st = con.prepareStatement();
    String SQL_CREATE_STUDENT = "INSERT INTO student(stdid,sname,branch,email,phone) VALUES (?,?,?,?,?)";
    st.setInt(1, id);
    st.setString(2, sName);
    st.setString(3, branch);
    ...