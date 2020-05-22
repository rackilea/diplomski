int consPairSum(int[] array, int left, int right) {
    if(right <= left + 1) return 0;

    int mid = (left + right) / 2;
    int leftPairSum = consPairSum(array, left, mid);
    int rightPairSum = consPairSum(array, mid, right);
    return leftPairSum + rightPairSum + array[mid - 1] + array[mid];
}