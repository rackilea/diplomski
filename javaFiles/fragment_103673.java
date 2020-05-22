public static void main(String[] args) {
    System.out.print("Enter the number: ");
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    final char[][] diamond = makeDiamond(num);
    for (int i = 0; i < diamond.length; i++) {
        for (int j = 0; j < diamond[i].length; j++) {
            System.out.print(diamond[i][j]);
        }
        System.out.println();
    }
}

public static char[][] makeDiamond(int n) {
    int width = 1 + 4 * (n - 1);
    int height = 1 + 2 * (n - 1);
    char[][] out = new char[height][width];
    int x0 = 2 * (n - 1);
    int y0 = n - 1;
    for (int i = 0; i < width; i += 2) {
        // Top borders
        int y1 = Math.abs(y0 - i / 2);
        out[y1][i] = '*';

        // Bottom borders
        int y2 = height - Math.abs(i / 2 - y0) - 1;
        out[y2][i] = '*';

        if ((x0 - i) % 4 == 0) {
            // Plus signs
            for (int j = y1 + 1; j < y2; j++) {
                out[j][i] = '+';
            }
        }
    }
    return out;
}