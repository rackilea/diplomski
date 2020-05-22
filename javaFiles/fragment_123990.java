int[] key = new int[]{3, 8, 6};
        int[] target = new int[]{3, 6, 8, 8, 6, 3, 8, 6, 2, 4};
        for (int i = 0; i < target.length; i++) {
            int j = 0;
            for (j = 0; j < key.length && (i + j) < target.length; j++) {
                if (target[i + j] != key[j]) {
                    break;
                }
            }
            if (j == key.length && j != 0) {
                System.out.print("{");
                for (j = 0; j < key.length; j++) {
                    System.out.print(i + j);
                    if (j != key.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("}");
            }

        }