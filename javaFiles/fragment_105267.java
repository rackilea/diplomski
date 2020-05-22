int x= 707; //10110011
int oddBits = 0x5555; //01010101
int evenBits = 0xAAAA; //10101010

int oddResult = x & oddBits;
System.out.println(oddResult);

int evenResult = x & evenBits;
System.out.println(evenResult);