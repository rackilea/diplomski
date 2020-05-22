public String  generateString(int seed) {
   Random rnd = new Random(12);
   int len = 10 + rnd.nextInt()  % 20; // achieving random string length in [10, 30)
   StringBuilder sb = new StringBuilder(); // here we will build the string
   for (int i = 0; i < len; i++) {
        sb.append(32 + (char) rnd.nextInt() % 94); // displayable ASCIs are between 32 and 127
   }
   return sb.toString();
}