public static long interleave(int a, int b) {
    long ans = 0;
    for (int i = 0; i < 32; i++)
    {
        if ((a & (1<<i)) != 0)     // the bit at position i in a is 1
        {
            ans |= 1L << i*2 + 1;  // set the bit at position (i*2 + 1) in ans to 1
        }
        if ((b & (1<<i)) != 0)     // the bit at position i in b is 1
        {
            ans |= 1L << i*2;      // set the bit at position (i*2) in ans to 1
        }
    }
    return ans;
}