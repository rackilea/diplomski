String test = "STACK";
int[] numbers = wordsToNumbers(test, 1);
for (int i = 0; i < test.length(); i++) {
    char c = test.charAt(i);
    System.out.printf("%s=%d\n", c, numbers[i]);
}