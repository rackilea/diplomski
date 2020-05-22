public static int myswap(int x, int i, int j)
{
    // b is 1 if the bits are different (xor), 0 if not
    int b = ((x >> i) ^ (x >> j)) & 1;
    // flip the bits if they are different
    return x ^ ((b << i) | (b << j));
}