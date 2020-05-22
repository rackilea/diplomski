private static boolean isRemainder0(AtomicInteger remainder) {
    boolean is0 = true;
    if (remainder.intValue() > 0) {
        remainder.decrementAndGet();
        is0 = false;
    }
    return is0;
}

public static void main(String[] args) {
    AtomicInteger remainder = new AtomicInteger(5);

    System.out.println(remainder);
    System.out.println(isRemainder0(remainder));
    System.out.println(remainder);
}