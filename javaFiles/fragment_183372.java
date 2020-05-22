static {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (final ClassNotFoundException e) {
        e.printStackTrace();
    }
}