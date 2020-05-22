int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

int last = numbers[numbers.length - 1]; // last now stores 10

// for index 9 to index 1, copy numbers to the right
for (int i = numbers.length - 1; i > 0; --i) {
    numbers[i] = numbers[i - 1];
}

numbers[0] = last; // the first number is now 10