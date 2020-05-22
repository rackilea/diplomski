ArrayList<String> stringArr = new ArrayList<>();
try (Session session = ServerConnect.getSessionFactory().openSession()) {
    String query = "";
    switch (dbName) {
        case "sakila":
            query = "SHOW TABLES FROM sakila";
            break;

        case "foo":
            query = "SHOW TABLES FROM foo";
            break;

        // other database names go here
    }

    NativeQuery nativeQuery = session.createNativeQuery(query);
    nativeQuery.setParameter("dbName", dbName);
    List list = nativeQuery.list();

    for(Object database: list){
        stringArr.add(String.valueOf(database));
    }
}