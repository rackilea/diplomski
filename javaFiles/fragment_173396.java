int size = file.nextInt();
    file.nextLine(); // added
    System.out.println("Size: " + size);

    boolean[][] matrix = new boolean[size][size];
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            matrix[i][j] = file.nextBoolean();
        }
        file.nextLine(); // added
    }