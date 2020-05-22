int x = 0xaabcdabcd;
int mask = 0x0fffffff;
for(int i =0;i < 8; i ++){
    System.out.println(x & mask);
    x = x >>> 4;
}