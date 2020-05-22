public static void main(String[] args) {
    String result = "http://sdsadasd/time/time.jsp?tp=&a".replaceFirst("time\\.jsp", "java.jsp");
    System.out.println(result);
}

// Print: 
http://sdsadasd/time/java.jsp?tp=&a