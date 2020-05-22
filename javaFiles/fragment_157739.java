int a = 1;
int b = 1;
int c = a + b;
long sum = 0;
while (c < 4_000_000) {
   sum += c;
   a = b + c;
   b = a + c;
   c = a + b; // skip forward to the next even fibonacci
}