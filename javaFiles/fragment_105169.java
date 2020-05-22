int[] input = new int[]{0, 0, 0, 0, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 5, 5, 5, 5, 8, 8, 10, 10, 2, 2, 2, 3, 3, 7, 7};
    int current = input[0];
    boolean found = false;

    for (int i = 1; i < input.length; i++) {
        if (current == input[i] && !found) {
            found = true;
        } else if (current != input[i]) {
            System.out.print(" " + current);
            current = input[i];
            found = false;
        }
    }
    System.out.print(" " + current);