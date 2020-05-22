class Board {

    char[][] ch;
    boolean[][] visited;

    Trie dictionary;

    void find() {
        StringBuilder prefix = new StringBuilder();
        for (int x = 0; x < maxx; x++) {
            for (int y = 0; y < maxy; y++) {
                walk(x, y, prefix);
            }
        }
     }

    void walk(int x, int y, StringBuilder prefix) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            prefix.append(ch[x][y]);

            if (dictionary.hasPrefix(prefix)) {
                if (dictionary.contains(prefix)) {
                    System.out.println(prefix);
                }

                int firstX = Math.max(0, x - 1);
                int lastX = Math.min(maxx, x + 1);
                int firstY = Math.max(0, y - 1);
                int lastY = Math.min(maxy, y + 1);
                for (int ax = firstX; ax <= lastX; ax++) {
                    for (int ay = firstY; ay <= lastY; ay++) {
                        walk(ax, ay, prefix);
                    }
                }
            }

            prefix.setLength(prefix.length() - 1);
            visited[x][y] = false;
        }
    }