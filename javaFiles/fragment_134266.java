ArrayList list = new ArrayList();

list.add("0 , 0 , 0 , 4 , 2 , 0 , 2 , 0 , 1 , 0 , 0 , 0");

list.add("1 , 0 , 0 , 4 , 2 , 0 , 3 , 0 , 1 , 0 , 0 , 1");

list.add("2 , 0 , 0 , 4 , 1 , 0 , 2 , 0 , 1 , 0 , 0 , 0");

//now go through the ArrayList and split each entry by ',' and add to a 2D array, JTable

int[][] JTable = new int[list.size()][];
for (int row = 0; row < list.size(); row++) {
    //get an item from the ArrayList
    String rowString = list.get(row);
    //remove all the whitespaces from the string
    rowString = rowString.replaceAll("\\s+","");
    //split the string using "," as a delimiter
    String[] items = rowString.split(",");
    JTable[row] = new int[items.length];
    for (int col = 0; col < items.length; col++) {
        JTable[row][col] = Integer.parseInt(items[col]);
    }
}