try {
       Throwable t = new Throwable();
       throw t.fillInStackTrace();
} catch (Exception e) {
    System.out.println("outer exception handler");
    e.printStackTrace();
}