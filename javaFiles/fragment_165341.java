// read the width and height
int height = scan.nextInt();
int width = scan.nextInt();
// build the 2D array to store the char grid.
char[][] chars = new char[height][];
for (int line = 0; line < height; line++) {
    chars[line] = scan.next().toCharArray();
}