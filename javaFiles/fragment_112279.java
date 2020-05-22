int[] numbers = { 11, 6, 4, 5, 7, 1 };
Arrays.sort(numbers);
int numbersArrayIndex = 0;
for (int i = 0; i < numbers[numbers.length - 1]; i++) {
    if (i == numbers[numbersArrayIndex]) {
        numbersArrayIndex++;
    }
    else {
        System.out.println(i);
    }
}