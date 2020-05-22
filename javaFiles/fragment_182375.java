//Call the partiarch to start drawing
XSSFDrawing drawing = ((XSSFSheet)currentSheet).createDrawingPatriarch();
//Create CTMarket for anchor
CTMarker chartEndCoords = CTMarker.Factory.newInstance();
//The coordinates are set in columns and rows, not pixels.
chartEndCoords.setCol(column);
//Set Column offset
chartEndCoords.setColOff(0);
chartEndCoords.setRow(row);
chartEndCoords.setRowOff(0);
//drawing.getCTDrawing().getTwoCellAnchorArray(0).setFrom(chartStartCoords);
drawing.getCTDrawing().getTwoCellAnchorArray(0).setTo(chartEndCoords);

/*
    This line of code allows to resize the chart:
        The Patriarch is what allows to get control over the drawings, since
        a chart is considered a graph in xlsx you can access it with getCTDrawing.
        Each graph is stored in the tag getTwoCellAnchorArray, where the array position
        is the chart you have; for example getTwoCellAnchorArray(3) would refer to the
        forth graph within the sheet.

        Each getTwoCellAnchorArray has several properties as FROM and TO, which define
        where the existing graph starts and ends.   
*/