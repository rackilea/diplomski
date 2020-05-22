public static void main(String[] args) throws Exception {
    int i = 9;
    System.out.println(Integer.toBinaryString(i));
    i >>= 1;
    System.out.println(Integer.toBinaryString(i));
    i >>= 1;
    System.out.println(Integer.toBinaryString(i));
    i >>= 1;
    System.out.println(Integer.toBinaryString(i));
}