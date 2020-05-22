try {
    System.out.println(1 / 0);
} catch (ArithmeticException e) {
    System.out.println("Trying to divide by 0 is not ok.");
} catch (RuntimeException e) {
    System.out.println("Runtime exception");
} finally {
    System.out.println("The program will now exit");
}