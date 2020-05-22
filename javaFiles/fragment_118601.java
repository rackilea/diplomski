final String[][] theGrid = new String[4][4];
final List<String> tokens = Arrays.asList("?", "+", "-", "*", "!", "/", "#", "%", "?", "+", "-", "*", "!", "/", "#", "%");
Collections.shuffle(tokens);

int i = 0, j = 0;
for (final String token : tokens) {
    theGrid[i][j] = token;
    if (++j == 4) {
        j = 0;
        ++i;
    }
}