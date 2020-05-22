int n = 7; //equals 0111

n<<=3;  //signed left shift 0111 3 spaces which equals 0111000

n=n&n+1|n+2^n+3; // (0111000 and 0111001) or (0111010 xor 0111011)
                 // 0111000 or 0000001
                 // 0111001

n>>=2;  //signed right shift 0111001 2 spaces equals 0001110 which equals 14
System.out.print(n);