String write(MyENum[][] myArray) {
    String res = "";
    for (int iRow = 0; iRow < myArray.length; iRow++) {
        for (int iCol = 0; iCol < myArray[iRow].length; iCol++)
            res += URLEncoder.encode(myArray[iRow][iCol].name(), "UTF-8")+",";
        res += "\n";
    }
}