public static class Screen {
    private char[][] screen;
    private static final String BORDER = "*";

    public Screen(int height, int width) {
        screen = new char[height][width];
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                screen[i][j] = ' ';
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // add (screen.length + 2) for the first line.
        for (int i = 0; i < screen.length + 2; i++) {
            sb.append(BORDER);
        }
        sb.append(System.getProperty("line.separator"));

        for (int i = 0; i < screen.length; i++) {
            // star at the begin of each line
            sb.append(BORDER);
            for (int j = 0; j < screen[i].length; j++) {
                sb.append(screen[i][j]);
            }
            // star at the end of each line
            sb.append(BORDER);
            sb.append(System.getProperty("line.separator"));
        }

        // add (screen.length + 2) for the last line.
        for (int i = 0; i < screen.length + 2; i++) {
            sb.append(BORDER);
        }

        return sb.toString();
    }
}