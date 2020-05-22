@Test
public void test() {
    System.out.format("%s%n", 1.12345e37);

    System.out.format("%e%n", 1.12345e37);
    System.out.format("%f%n", 1.12345e37);
    System.out.format("%g%n", 1.12345e37);

    System.out.format("%E%n", 1.12345e37);
    System.out.format("%G%n", 1.12345e37);
}