<script>
  var currentRow = 1;
  var currentColumn = 2;
  var rowVals = [3,4];
  var colVals = [5,6];

  function mycall() {
    window.handleAnchorClick(currentRow, currentColumn, rowVals, colVals);
  }
</script>

<!-- I prefer this -->
<a href="#" onClick="javascript:mycall()">click</a>

<!-- But this should work as well -->
<a href="#" onClick="window.handleAnchorClick(currentRow,currentColumn,rowVals,colVals)">click</a>