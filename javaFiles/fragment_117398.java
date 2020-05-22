public static int findOddNumber(int[] numbers, int startIndex, int endIndex) {
    if (numbers[startIndex] == numbers[endIndex])
        return numbers[startIndex];
    int mid = (startIndex + endIndex) / 2;
    int last = findLast(numbers, mid, endIndex);
    if (last % 2 == 1)
        return findOddNumber(numbers, last + 1, endIndex);
    else
        return findOddNumber(numbers, startIndex, mid - mid % 2);
}

private static int findLast(int[] numbers, int startIndex, int endIndex) {
    if (numbers[startIndex] == numbers[endIndex])
        return endIndex;
    int mid = (startIndex + endIndex) / 2;
    if (numbers[startIndex] == numbers[mid])
        return findLast(numbers, mid, endIndex - 1);
    else
        return findLast(numbers, startIndex, mid - 1);
}