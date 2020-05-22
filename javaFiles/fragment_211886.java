<script>
    var tdDetailList = [];
    function init() {
        var tdDetailTable = document.getElementById("tdDetailTable");       
        for (var i = 0, row; row = tdDetailTable.rows[i]; i++) {
            var tdDetail = {code : row.cells[0].innerHTML, datepicker2 : row.cells[1].innerHTML, datepicker3 : row.cells[2].innerHTML};         
            tdDetailList.push(tdDetail);
        }
        alert(getDetailTableJson());
    }

    function deleteRow(index){
       tdDetailList.splice(index, 1);
       var tdDetailTable = document.getElementById("tdDetailTable");
       tdDetailTable.deleteRow(index);
       alert(getDetailTableJson());
    }

    function getDetailTableJson(){
        return JSON.stringify(tdDetailList);
    }
</script>

<body onload="init();">
<table id="tdDetailTable">
<tr><td>1</td><td>2</td><td>3</td><td><a href="#" onclick="deleteRow(0); return true;">del</a></td></tr>
<tr><td>4</td><td>5</td><td>6</td><td><a href="#" onclick="deleteRow(1); return true;">del</a></td></tr>
</table>
</body>