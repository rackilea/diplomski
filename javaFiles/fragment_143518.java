static int oddCounts;

public static int oddDigitCounter(int number) {
    int moduledNumber, dividedNumber, absoluteInput = 0;

    absoluteInput = Math.abs(number);
    moduledNumber = absoluteInput % 2;
    dividedNumber = absoluteInput / 10;

    if (absoluteInput == 0) {
        return 0;
    } else if (moduledNumber == 0) {
        return oddDigitCounter(dividedNumber);
    } else {
        oddCounts++;
        return 1 + oddDigitCounter(dividedNumber);
    }
}