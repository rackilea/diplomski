ResourceBundle rb = ResourceBundle.getBundle("somepackage.resources");
Enumeration <String> keys = rb.getKeys();
while (keys.hasMoreElements()) {
    String key = keys.nextElement();
    String value = rb.getString(key);
    System.out.println(key + ": " + value);
}