public static int[] sum(int[] arr1, int[] arr2){
    int carry = 0;
    int sum = 0;

    int len1 = arr1.length;
    int len2 = arr2.length;
    int len = Math.max(len1, len2);

    int arr3[] = new int[len + 1];

    for (int i = 1; i <= len; i++) {
        sum =
            (len1 - i >= 0 ? arr1[len1-i] : 0)
            + (len2 - i >= 0 ? arr2[len2-i] : 0)
            + carry;

        arr3[len-i+1] = sum%10;
        carry = sum/10;
    }
    arr3[0] = carry;

    return arr3;
}