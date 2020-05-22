public static void main(String[] args) {
    int[][] array;

    array = createArray("3a");
    System.out.println(array.length + "," + array[0].length);

    array = createArray("5e");
    System.out.println(array.length + "," + array[0].length);

    array = createArray("9g");
    System.out.println(array.length + "," + array[0].length);
}

private static int[][] createArray(String input) {
    int a = Integer.parseInt(input.substring(0, 1)) - 1;
    int b = input.charAt(1) - 97;
    return new int[a][b];
}