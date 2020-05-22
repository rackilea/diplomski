final int input = 54365;
final int inputStr = String.valueOf(input);
final int number = 5;
int sum = 0;

for (final char c : inputStr.toCharArray()) {
    final int n = Character.getNumericValue(c);

    if (n == number) {
        sum += number;
    }
}