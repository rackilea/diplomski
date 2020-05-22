public static void main(String[] args) {
    int[] array1 = {5, 6};
    int[] array2 = new int[array1.length];
    int i;
    int j = array1.length -1;
    for (i = 0; i < array1.length; i++) {
        array2[i] = array1[j]; //  Fixed mistake
        j--;
    }
    for (int num : array2) { // fixed mistake
        System.out.println(num);
    }
}