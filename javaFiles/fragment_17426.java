<script>
$(document).ready(function() {
    /* Init DataTables */
    var oTable = $('#resource-table').dataTable();

    /* Apply the jEditable handlers to the table */
    $('td', oTable.fnGetNodes()).editable( 'out.jsp', {
        "callback": function( sValue, y ) {
            var aPos = oTable.fnGetPosition( this );
            oTable.fnUpdate( sValue, aPos[0], aPos[1] );
        },
        "submitdata": function ( value, settings ) {
            return {
                "row_id": this.parentNode.getAttribute('id'),
                "id": this.getAttribute('id'),
                "colName": this.getAttribute('col'),
                "column": oTable.fnGetPosition( this )[2]
            };
        },
        "height": "14px"
    } );
} );   

</script>