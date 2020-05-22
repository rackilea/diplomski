... 

    String[][] newData = new String[43][];
    for(int i=0; i<data.length; i++) {
        String[] row = data[i];
        newData[i] = Arrays.copyOf(row, row.length + 1);
    }

    // fill in new data column in newData