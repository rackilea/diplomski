try {
    Integer.parseInt(null); // throws java.lang.NumberFormatException: null
}
catch (Exception e) {
    System.out.println("Integer: " + e.getClass().getName());
}
try {
    Double.parseDouble(null); // throws java.lang.NullPointerException
}
catch (Exception e) {
    System.out.println("Double: " + e.getClass().getName());
}