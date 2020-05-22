private static final int K_PRIME = (int) 2999999929L;

public static int hash(int a, int r) {
   // return (a * K_PRIME % (2^32)) >>> (32 - r);
   return (a * K_PRIME) >>> -r;
}