final int SIZE = 244;
for (int column = 0; column < 3; column++) {
    Object[] arr = new Object[SIZE];
    int currentColIndex = column * SIZE;
    for (int row = 0; row < arr.length; i++)
        arr[row] = a[currentColIndex + row];
    data.put("0" + (column+1), arr);
}