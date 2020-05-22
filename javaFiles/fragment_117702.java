connection = DriverManager.getConnection(URL, USER, PASSWORD);
Statement st = connection.createStatement();
ResultSet result = st.executeQuery("select * from department");
JTable t=new JTable();
t.setModel(buildTableModel(result));
s1.setViewportView(t);