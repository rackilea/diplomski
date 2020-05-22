public static long multiply() {
    int mul = 1;
    for(int i = 0; i <= 12; i++) {
        mul = mul * Integer.parseInt(list.get(i));
    }
    return mul;
}