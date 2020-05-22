/**
 * Applies a whole-row cell styling to the row.
 * If the value is null then the style information is removed,
 *  causing the cell to used the default workbook style.
 */
@Override
public void setRowStyle(CellStyle style) {
    if(style == null) {
       if(_row.isSetS()) {
          _row.unsetS();
          _row.unsetCustomFormat();
       }
    } else {
        StylesTable styleSource = getSheet().getWorkbook().getStylesSource();

        XSSFCellStyle xStyle = (XSSFCellStyle)style;
        xStyle.verifyBelongsToStylesSource(styleSource);
        long idx = styleSource.putStyle(xStyle);
        _row.setS(idx);
        _row.setCustomFormat(true);
    }
}