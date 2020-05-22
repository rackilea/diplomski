long start = System.currentTimeMillis();
char[] chars = new char[500];
Arrays.fill(chars, '.');
for (int i = 0; i < 30000; i++) {
    String input = new String(chars);
    StringBuilder output = new StringBuilder();
    for (int j = 0; j < 50; j++) {
        output.append(input, j * 10, j * 10 + 9);
    }
    String out = output.toString();
}
System.out.println("Took: " + (System.currentTimeMillis() - start) / 1e3 + " seconds");