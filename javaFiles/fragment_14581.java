PreparedStatement st = conn.prepareStatement("INSERT INTO TASKS (ID, TITLE, DESCRIPTION, DATE) VALUES (?, ?, ?, ?)");
st.setInt(1, idCur);
st.setString(2, title);
st.setString(3, description);
st.setObject(4, date);
st.executeUpdate();
st.close();