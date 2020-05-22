function addRow(){
    alert("inside addRow");
    var list = new Array();
    var value = new Array();
    var i = 0;
    <logic:iterate name="countryForm" property="countryList" id="country">
      list[i] = '<bean:write name="country" property="countryName" />';
      value[i] = '<bean:write name="country" property="countryId" />';
      i++;
    </logic:iterate>

    var table = document.getElementById('tableID');
    var rowCount = table.rows.length;
    var countval = rowCount;
    var row = table.insertRow(rowCount);

    //country

    var cell1 = row.insertCell(0);
    var element1 = document.createElement("select");
    element1.style.width = "250px";
    element1.id = "countryId" + countval;

    var o = document.createElement('option');
    o.value = "0";
    o.text = "[SELECT]";
    element1.options.add(o);
    cell1.appendChild(element1);

    for(i=0; i<list.length; i++){
        var item = document.createElement('option');
        item.value = value[i];
        item.text = list[i];
        element1.options.add(item);
        cell1.appendChild(element1);
    }
}