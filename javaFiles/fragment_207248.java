function onEdit(event){
    var sheet = event.source.getActiveSheet();
    var editedCell = sheet.getActiveCell();

    var columnToSortBy = 10;
    var tableRange = "J:J3"; // What to sort. 

    if(editedCell.getColumn() == columnToSortBy){   
        var range = sheet.getRange(tableRange);
        range.sort( { column : columnToSortBy, ascending: true } );

        onEdit2(event);    // Execute the function, passing it whatever event was passed to onEdit
    }
  } // End definition of onEdit


function onEdit2(passedEvent) {     // Do the actual function definition out here
    var ss = SpreadsheetApp.getActiveSpreadsheet();
    var s = passedEvent.source.getActiveSheet();
    var r = passedEvent.source.getActiveRange();

    if(s.getName() == "Orders" && r.getColumn() == 10 && r.getValue() == "5. Archive") {
        var row = r.getRow();
        var numColumns = s.getLastColumn();
        var targetSheet = ss.getSheetByName("Archive");
        var target = targetSheet.getRange(targetSheet.getLastRow() + 1, 1);
        s.getRange(row, 1, 1, numColumns).moveTo(target);
        s.deleteRow(row);
    }
}