// Use ints to avoid any possible confusion due to signed byte values
int sourceByte = 0xFF & (int)(hexToBin[n]);  // Convert byte to unsigned int
int mask = 0x80;
for (int i = 0; i < 8; i++) {
    int maskResult = sourceByte & mask;  // Extract the single bit
    if (maskResult != 0) {
         allBits[8*n + i] = 1;
    }
    else {
         allBits[8*n + 1] = 0;  // Unnecessary since array is inited to zero but good documention
    }
    mask = mask >> 1;
}