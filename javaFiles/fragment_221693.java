final int WIDTH = 11;
final int HEIGHT = 18;
final int CHAR_COUNT = 10;
final char[] CHARS = { 'L', 'O', 'U' };

// Create matrix filled with '.'
char[][] matrix = new char[HEIGHT][WIDTH];
for (int i = 0; i < HEIGHT; i++)
    Arrays.fill(matrix[i], '.');

// Randomly place CHAR_COUNT of each character from CHARS
Random random = new Random();
for (char ch : CHARS) {
    for (int i = 0, x, y; i < CHAR_COUNT; i++) {
        do {
            x = random.nextInt(WIDTH);
            y = random.nextInt(HEIGHT);
        } while (matrix[y][x] != '.'); // Already filled, try again
        matrix[y][x] = ch;
    }
}

// Print matrix
for (char[] row : matrix)
    System.out.println(row);