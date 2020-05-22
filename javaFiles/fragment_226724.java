try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
            Statement st= conn.createStatement();
// suppose name,roll,gender,dob are field in which u need the datas to be inserted
            String query="insert into student (name,roll,gender,dob) values('"+name+"','"+roll+"','"+address+"','"+gender+"','"+dob+"')";
            System.out.println(query);
            st.executeUpdate(query);
            st.close();
            conn.close();
          }
            catch(Exception e){
           //System.out.println("database");
            e.printStackTrace();
            }