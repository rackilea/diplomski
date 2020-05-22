int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

    int input = keyboard.nextInt();
    if (input > max) {
        secondMax = max;
        max = input;
    } else if (input > secondMax) {
        secondMax = input;
    }
    if (input < min) {
        secondMin = min;
        min = input;
    } else if (input < secondMin) {
        secondMin = input;
    }