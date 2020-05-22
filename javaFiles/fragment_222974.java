// as add()
int h = element * 0x9E3779B9;
int i = h >>> (32 - hashSizePower);
while (hash[i] != 0) {
    if (--i < 0) i += hashSize;
}
hash[i] = element;

// contains() similarly