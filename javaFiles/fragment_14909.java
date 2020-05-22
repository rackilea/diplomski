try {
    int i = 1 / 0;
} catch (Exception e) {
    System.out.println("exception  = " + e);
    System.out.println("getMessage = " + e.getMessage());
}