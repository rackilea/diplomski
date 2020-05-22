private static Object[] isRemainder0(Integer remainder) {
    boolean is0 = true;
    if (remainder.intValue() > 0) {
        remainder = remainder.intValue() - 1;
        is0 = false;
    }
    return new Object[]{is0, remainder};
}

public static void main(String[] args) {
    Integer remainder = 5;

    System.out.println(remainder);
    Object[] result = isRemainder0(remainder);
    System.out.println(result[0]);
    remainder = (Integer)result[1];
    System.out.println(remainder);
}