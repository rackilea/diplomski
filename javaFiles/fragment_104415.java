Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, usr,
                pwd);

            //.....

        PreparedStatement st=null;
        ResultSet rset=null;
        try {
            st = connection
                    .prepareStatement("SELECT first_name,last_name,email FROM People");

            List<Person> peoples = new ArrayList<Person>();

            rset = st.executeQuery();

            while (rset.next()) {
                Person newPerson = new Person();
                newPerson.firstName = rset.getString("first_name");
                newPerson.lastName = rset.getString("last_name");
                newPerson.email = rset.getString("email");
                peoples.add(newPerson);
            }

        } finally {

            try {
                rset.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }