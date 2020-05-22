List<Integer> list = Arrays.asList(1, 3, 6);
for (Cell cell : row) {
    if (list.contains(cell.getColumnIndex())) {
        String result = getCellData(xssfWorkbook, cell);
        System.out.println(result);
    }
}