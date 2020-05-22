char previous = 0;
char[] chars = str.toCharArray();
for (int i = 0; i < chars.length(); i++) {
   if (chars[i] == previous) {
       System.out.println(previous + "" + previous);
   }
   previous = chars[i];
}