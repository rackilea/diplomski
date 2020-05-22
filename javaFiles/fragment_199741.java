final String s = "Hello World!";
final int frequencies[] = new int[128];

for (int i = 0; i < s.length(); i++) {
    final int ascii = (int) s.charAt(i);
    frequencies[ascii]++;
}