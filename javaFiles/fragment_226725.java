try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
// suppose name,roll,gender,dob are field in which u need the datas to be inserted
                PreparedStatement st = conn.prepareStatement("insert into student (name,roll,gender,dob) values(?,?,?,?)");
                st.setString(1, name);
                st.setString(2, roll);
                st.setString(3, gender);
                st.setDate(4, dob);
                st.executeUpdate();
                st.close();
                conn.close();
              }
                catch(Exception e){
               //System.out.println("database");
                e.printStackTrace();
                }