int n = 0x12345678;
int m = 0x55555555;

int i = 4; // assume right to left
int j = 15;

int mask = 0;
for (int pos = i; pos <= j; pos++) {
    mask = mask | (1 << pos);
}
System.out.println(String.format("mask is     0x%08x", mask));

int nCleared = n & ~mask;
System.out.println(String.format("clear n     0x%08x", nCleared));

int bitsFromM = (m & mask);
System.out.println(String.format("Bits from m 0x%08x", bitsFromM));

int nWithM = bitsFromM | nCleared;
System.out.println(String.format("n with m    0x%08x", nWithM));