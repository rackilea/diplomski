Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection("", "", "");
             //.....

    try (PreparedStatement st = connection
            .prepareStatement("SELECT first_name,last_name,email FROM People")) {

        List<Person> peoples = new ArrayList<>(); // but should be new ArrayList<Person>();

        try (ResultSet rset = st.executeQuery()) {

            while (rset.next()) {
                Person newPerson = new Person();
                newPerson.firstName = rset.getString("first_name");
                newPerson.lastName = rset.getString("last_name");
                newPerson.email = rset.getString("email");
                peoples.add(newPerson);
            }
        }
    }