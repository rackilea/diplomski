String sql = "INSERT INTO Users (username, password, email, firstname, lastname)"
    + " values (?,?,?,?,?)";
//...
st.setString(1, username);
st.setString(2, password);
st.setString(3, email);
st.setString(4, firstname);
st.setString(5, lastname);
//...