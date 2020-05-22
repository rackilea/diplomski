MyEnum[][] read(String res) {
    String[] rows = res.split("\n");
    MyEnum[][] myArray = new MyEnum[rows.length][];
    for (int iRow; iRow < rows.length; iRow++) {
        String[] cols = rows[iRow].split(",");
        myArray[iRow] = new MyEnum[cols.length];
        for (int iCol = 0; iCol < cols.length; iCol++)
            myArray[iRow][iCol] = MyEnum.valueOf(URLDecoder.decode(cols[iCol], "UTF-8"));
    }
    return myArray;
}