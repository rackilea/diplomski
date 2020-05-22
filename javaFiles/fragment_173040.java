private void printByColumns(String[][] jaggedArray) {
    int maxColumns = 0;
    for(int i = 0; i < jaggedArray.length; i++) {
         maxColumns = Math.max(jaggedArray[i].length, maxColumns);
    }

    for(int i = 0; i < maxColumns; i++) {
        String text = "";

        for(int j = 0; j < jaggedArray.length; j++) {
            if (i < jaggedArray[j].length) {
                text += String.format("%s\t", jaggedArray[j][i]);
            }
        }

        System.out.println(text);
    }
}