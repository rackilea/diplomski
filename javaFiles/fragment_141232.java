public static void main(String[] args) {
    try {
        Connection connection = createConnection();
        try (connection) {
            populateTypes(connection);
        }

        MyType type;

        type = MyType.byId(10);
        System.out.println(type.getName());

        type = MyType.byId(20);
        System.out.println(type.getName());

        type = MyType.byId(30);
        System.out.println(type.getName());

    } catch (Exception e) {
        e.printStackTrace();
    }
}