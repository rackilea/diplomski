XSSFDrawing draw= ((XSSFSheet)currentSheet).createDrawingPatriarch();
CTMarker chartEndCoords = CTMarker.Factory.newInstance();
chartEndCoords.setCol(column);
chartEndCoords.setColOff(0);
chartEndCoords.setRow(row);
chartEndCoords.setRowOff(0);
draw.getCTDrawing().getTwoCellAnchorArray(0).setTo(chartEndCoords);