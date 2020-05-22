public static void main(String args[]) {
        int size = 2;      // change the size ans get your truth table.
        generateTable(0, size, new int[size]);
    }

    private static void generateTable(int index, int size, int[] current) {
        if (index == size) {
            for (int i = 0; i < size; i++) {
                System.out.print(current[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < 2; i++) {
                current[index] = i;
                generateTable(index + 1, size, current);
            }
        }
    }