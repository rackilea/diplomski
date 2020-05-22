$(document).ready(function () {
    var entity = {mag: "status_key", paper: "View10"};
    $("#btn").click(function () {
        $.ajax({
            url: "/apipath/ajaxJsonPost",
            type: 'post',
            dataType: 'json',
            data: JSON.stringify(entity),
            contentType: 'application/json',
            success : function(response) {    
                  alert(response);
            },
            error : function() {
                  alert('error');
            }
        });
    });
});