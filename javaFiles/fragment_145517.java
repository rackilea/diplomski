$(document).ready(function() {
  $('#example').dataTable( {
    "bProcessing": true,
    "bServerSide": true,
    "sAjaxSource": "scripts/server_processing.php" // for you it will be - /getWidgetsByType
  } );
} );