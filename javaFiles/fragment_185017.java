long x = 0b101011;
char[] cs = new char[bs.length()];
Arrays.fill(cs, '0');

BitSet bs = BitSet.valueOf(new long[]{x});
for (int i = bs.nextSetBit(0); i >=0 ; i = bs.nextSetBit(i+1)) {
    cs[bs.length()-i-1] = '1';
    System.out.println(new String(cs));  // or whatever you want to do with this String
    cs[bs.length()-i-1] = '0';
}