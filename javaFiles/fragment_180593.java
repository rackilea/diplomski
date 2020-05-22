String[] cols = new String[]{"A", "B", "C"};
for (int rowIndex = 1; rowIndex < 4; rowIndex++) {
    for (String colValue : cols) {
        String cell = colValue + rowIndex;
        int col = cell.toLowerCase().charAt(0) - 'a';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        int index = (row * 3) + col;
        System.out.println("Cell = " + cell + "; index = " + index);
    }
}