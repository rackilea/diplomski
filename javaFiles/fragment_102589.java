int high = 4; // binary 0100
int low = 2; // binary 0010
int value = (high << 4) | low;

int value = (0100 << 4) | 0010; // shift 4 to left
int value = 01000000 | 0010; // bitwise or
int value = 01000010;
int value = 66; // 01000010 == 0x42 == 66