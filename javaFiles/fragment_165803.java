function recluster() {
    $.ajax({
        url:'ReClusterServlet',
        type:'POST',
        success:function() {   //handle the successful return by reloading the current page
            location.reload();
        }
    });
}