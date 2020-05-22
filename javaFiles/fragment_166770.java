function processTable(tableId) {
    var jsonTable = [];
    var tableObj = document.getElementById(tableId);
    if (tableObj) {
        for (var x=0, y=tableObj.rows.length; x < y; x++) {
            var tableRow = tableObj.rows[x];
            var jsonRow = [];
            for (var i=0, j=tableRow.cells.length; i < j; i++) {
                var tableCell = tableRow.cells[i];
                // removes any line feeds or tabs
                jsonRow.push(tableCell.innerHTML.replace(/\t|\n/g, ""));
            }
            jsonTable.push(jsonRow)
        }
    }
    return JSON.stringify(jsonTable);
}