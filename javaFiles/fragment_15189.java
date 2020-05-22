public static void main(String[] args) {
    Long sum = 0L; // uses Long, not long
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
        sum += i;
    }
    System.out.println(sum);
}