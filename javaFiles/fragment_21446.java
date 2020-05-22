int num = 12345;
int sum = 0;
int pos = 0;
while(num > 0) {
    int digit = num % 10;    // make it really blatantly clear what the DIGIT is
    if (pos % 2 == 0)
      sum += digit;
    num /= 10;
    pos++;
}