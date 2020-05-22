boolean[] digits = new boolean[10];
int digit = stack1.pop();
if (digits[digit]) {
    // found the digit do something with it
} else {
    digits[digit] = true;
}