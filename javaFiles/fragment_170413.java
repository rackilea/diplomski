Thread 1:
A = 1;   // 1
Bv = 1;  // 2
C = 1;   // 3

Thread 2:

int c = C;  // 4
int b = Bv; // 5
int a = A;  // 6