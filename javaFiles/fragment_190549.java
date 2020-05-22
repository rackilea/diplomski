class SizedClientAnchor extends XSSFClientAnchor
{
    private SizedClientAnchor(XSSFSheet sheet, int columnIndex, int rowIndex, int w, int h)
    {
        super((XSSFSheet) cell.getSheet(), createCTMarker(columnIndex, rowIndex), getSize2D(w, h));
    }

    private static CTMarker createCTMarker(int columnIndex, int rowIndex)
    {
        CTMarker ret = CTMarker.Factory.newInstance();
        ret.setCol(columnIndex);
        ret.setColOff(0);
        ret.setRow(rowIndex);
        ret.setRowOff(0);
        return ret;
    }

    private static CTPositiveSize2D getSize2D(int w, int h)
    {
        CTPositiveSize2D ret = CTPositiveSize2D.Factory.newInstance();
        ret.setCx(w);
        ret.setCy(h);
        return ret;
    }
}