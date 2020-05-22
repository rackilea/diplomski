Random rnd = new Random();
int bits = 12;      // bits in "byte"
int length = 10;    // number of "bytes" in string
int n = 32;         // number of strings

for (int i = 0; i < n; i++) {
   StringBuilder sb = new StringBuilder();
   for (int j = 0; j < length; j++) {
      sb.append(Integer.toHexString(rnd.nextInt(1 << bits))).append(' ');
   }
   System.out.println(sb.toString());  // or write to file
}