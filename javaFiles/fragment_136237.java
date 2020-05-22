<script language="javascript">
    function addRow(tableID, data) {

        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);

        var cell1 = row.insertCell(0);
        cell1.innerHtml = data;

        var cell2 = row.insertCell(1);
        cell2.innerHTML = data;

        var cell3 = row.insertCell(2);
        cell3.innerHTML = data;             
    }
    </script>