// file test.java
class Test {
    public static void main(String[] args) {
    long start = System.nanoTime();
    long total = 0;
    for (int i = 0; i < 2147483647; i++) {
        total += i;
    }
    System.out.println(total);
    System.out.println(System.nanoTime() - start);
    }
}