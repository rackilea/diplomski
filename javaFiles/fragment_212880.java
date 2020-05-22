try {
    java.sql.Driver d = (java.sql.Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
    System.out.printf("%d.%d", d.getMajorVersion(), d.getMinorVersion());
} catch (InstantiationException e1) {
    e1.printStackTrace();
} catch (IllegalAccessException e1) {
    e1.printStackTrace();
} catch (ClassNotFoundException e1) {
    e1.printStackTrace();
}