function addRow(tableID) {               
    var table = document.getElementById(tableID);               
    var rowCount = table.rows.length;             
    var row = table.insertRow(rowCount);               
    var cell1 = row.insertCell(0);             
    var element1 = document.createElement("input");             
    element1.type = "checkbox";             
    element1.name = "chk_input";      //*** EDIT ***            
    cell1.appendChild(element1);               
    var cell2 = row.insertCell(1);             
    cell2.innerHTML = rowCount + 1;               
    var cell3 = row.insertCell(2);             
    var element2 = document.createElement("input");             
    element2.type = "text";
    element2.name = "text_input";     //*** EDIT ***
    cell3.appendChild(element2);           
}