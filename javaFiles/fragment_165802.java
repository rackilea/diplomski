function recluster() {
    $.ajax({
        url:'ReClusterServlet',
        type:'POST'
    });
}