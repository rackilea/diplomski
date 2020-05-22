public void setHyperlink(Hyperlink hyperlink) {
    XSSFHyperlink link = (XSSFHyperlink)hyperlink;

    // Assign to us
    link.setCellReference( new CellReference(_row.getRowNum(), _cellNum).formatAsString() );

    // Add to the lists
    getSheet().addHyperlink(link);
}