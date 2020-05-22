public List<String> getAllNames() {
    System.out.println("Test");
    List<String> names = new ArrayList<>();

    if (connection == null) {
         // do something here: return the empty collection or throw an exception.
    }
    try {
        Statement statement = connection.createStatement();
        ResultSet results = statement
                .executeQuery("SELECT name FROM patients");

        System.out.println("TEST 2");

        //Add all names to array
        while (results.next()) {
            String name = results.getString("name");
            names.add(name);
        }
    } catch (SQLException e) {
        System.out.println("getAllNames: " + e.getMessage());
    }

    return names;