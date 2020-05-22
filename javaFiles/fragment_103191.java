int sum = 0;       // 1 time
int i = 0;         // 1 time
while (i < n) {    // n+1 times
  int a = 0;       // n times
  while (a < i) {  // 1 + 2 + ... + n = n*(n+1)/2 times
    sum++;         // 0 + 1 + ... + n-1 = n*(n-1)/2 times
    a++;           // 0 + 1 + ... + n-1 = n*(n-1)/2 times
  }
  i++;             // n times
}