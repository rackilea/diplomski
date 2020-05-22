public static int[] peakInArray(int[] arr2){

    int lengthInput = arr2.length;
    int[] peaks = new int[lengthInput];
    int peakIndex = 0;

    for (int i = 1; i<lengthInput - 1; i ++) {
        if (arr2[i] > arr2[i - 1] && arr2[i] > arr2[i + 1]) {
            //Store arr2[i] in peaks
            peaks[peakIndex] = arr2[i];
            peakIndex++;
        }
    }
 return peaks;
}