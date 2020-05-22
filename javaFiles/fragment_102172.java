<script>
$.ajax( '${pageContext.request.contextPath}/maze/View/${maze}', {
      type: 'GET',
      dataType: 'xml',
      success: function( response ) {
        drawMaze( response);
      },
      error: function( req, status, err ) {
        console.log( 'something went wrong', status, err );
      }
    });
</script>