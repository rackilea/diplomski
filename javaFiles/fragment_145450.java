public static void main(String[] args) {
    Integer[] five = new Integer[5];
    Integer[] ten = new Integer[10];
    Integer[] fifteen = new Integer[15];

    fillArray(five);
    fillArray(ten);
    fillArray(fifteen);

    int result1 = linearSearch(five, 37);
    int result2 = linearSearch(ten, 37);
    int result3 = linearSearch(fifteen, 37);

    System.out.println(Arrays.toString(five) + " " + result1);
    System.out.println(Arrays.toString(ten) + " " + result2);
    System.out.println(Arrays.toString(fifteen) + " " + result3);

}