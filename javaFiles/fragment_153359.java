public static void main(String[] args) throws Exception {
    System.out.println(truncate(14/3.0, 6));
}

public static double truncate(double value, int places) {
    if (places < 0) {
        throw new IllegalArgumentException();
    }

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = (long) value;
    return (double) tmp / factor;
}