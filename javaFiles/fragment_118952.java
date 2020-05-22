//Cell celdaActual is the actual cell in a row in a sheet in the book, the class
//has Spanish names and comments and is big for a post, so I'm just posting
//this function
public String getCellValue() {
    String strValor = "";
    int intValor;
    double dblValor;
    SimpleDateFormat objSimpleDateFormat;
    if (celdaActual != null) {
        strValor = celdaActual.toString();
        switch (celdaActual.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                strValor = strValor.trim();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(celdaActual)) {
                    objSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    strValor = objSimpleDateFormat
                        .format(celdaActual.getDateCellValue());
                } else {
                    dblValor = celdaActual.getNumericCellValue();
                    if (Math.floor(dblValor) == dblValor) {
                        intValor = (int)dblValor;
                        strValor = String.valueOf(intValor);
                    } else {
                        strValor = String.valueOf(dblValor);
                    }
                }
                break;
            case Cell.CELL_TYPE_BLANK:
                strValor = "";
                break;
            case Cell.CELL_TYPE_ERROR:
                strValor = "";
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                strValor = String.valueOf(celdaActual.getBooleanCellValue());
                break;
        }
    }
    return strValor;
}