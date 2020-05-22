PreparedStatement st=con.prepareStatement("INSERT INTO EMPLOYEE(employee_id,template)"+"values(?,?)");
st.setInt(1,23);
st.setBytes(2, enroller.getTemplate().serialize());

Statement st = con.createStatement();
ResultSet rec = st.executeQuery("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID=3");