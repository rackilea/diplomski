public static int[] reverseArray(int[] arr) {

int[] reverse = new int[arr.length];

for (int i = 0; i < reverse.length; i++) {

    reverse[i] = arr[arr.length - i];

}


return reverse;

}