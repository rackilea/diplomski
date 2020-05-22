String test = "test";
char[] chars = test.toCharArray();
char max = Character.MIN_VALUE;
char min = Character.MAX_VALUE;
for (int i = 0; i < chars.length; i++) {
  char c = chars[i];
  max = max > c ? max : c;
  min = min < c ? min : c;
}
System.out.println(min);