function addRow() {

    var medicinename = document.getElementById("medicinename");
    var time = document.getElementById("time");
    var duration = document.getElementById("duration");
    var when = document.getElementById("when");
    var table = document.getElementById("myTableData");

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    row.insertCell(0).innerHTML= '<input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)">';
    row.insertCell(1).innerHTML= '<input type="text" name="'+'rowMedicine'+rowCount+'" value="'+medicinename.value+'" readonly />';
    row.insertCell(2).innerHTML= '<input type="text" name="'+'rowTime'+rowCount+'" value="'+time.value+'" readonly />';
    row.insertCell(3).innerHTML= '<input type="text" name="'+'rowDuration'+rowCount+'" value="'+duration.value+'" readonly />';
    row.insertCell(4).innerHTML= '<input type="text" name="'+'rowWhen'+rowCount+'" value="'+when.value+'" readonly />';
    document.getElementById('medicinename').value='';
    document.getElementById('time').value='';
    document.getElementById('duration').value='';
    document.getElementById('when').value='';
}

function deleteRow(obj) {

    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("myTableData");
    table.deleteRow(index);
}

function addTable() {

    var myTableDiv = document.getElementById("myDynamicTable");

    var table = document.createElement('TABLE');
    table.border='1';

    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);

    for (var i=0; i<3; i++){
       var tr = document.createElement('TR');
       tableBody.appendChild(tr);

       for (var j=0; j<4; j++){
           var td = document.createElement('TD');
           td.width='75';
           td.appendChild(document.createTextNode("Cell " + i + "," + j));
           tr.appendChild(td);
       }
    }
    myTableDiv.appendChild(table);

}