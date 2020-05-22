public static void fillElements(char[][] array, int elements) {

        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length > max) {
                max = array[i].length;
            }
        }
        if (array.length * max < elements) throw new IllegalArgumentException();

        boolean[][] filled = new boolean[array.length][max];
        int i = 0;
        while (i < elements) {
            int x = (int) (Math.random() * array.length);
            int y = (int) (Math.random() * array[x].length);
            if (!filled[x][y]) {
                filled[x][y] = true;
                array[x][y] = 'B';
                i++;
            }
        }
    }