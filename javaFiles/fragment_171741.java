int minVal = scnr.nextInt(), sum = 0;
int[] arr = new int[rand.nextInt(100) + 1];
for (int i = 0; i < arr.length; i++) {
    arr[i] = rand.nextInt(100) + 1;
    if (arr[i] > minVal) {
        sum += arr[i];
    }
}
System.out.println(Arrays.toString(arr));
System.out.println(sum);