for (int row = 0; row < topicIndex.size(); row++) {
        System.out.printf("%-16s", topicList.get(row));
        for (int col = 0; col < documentIndex.size(); col++) {
            System.out.printf("%2d ", mat[row][col]);
        }
        System.out.println();
    }