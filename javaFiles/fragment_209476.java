try {
    String s = null;
    s.toLowerCase();
} catch (Exception e) {
    System.out.println("Line number is: " + e.getStackTrace()[0].getLineNumber());
}