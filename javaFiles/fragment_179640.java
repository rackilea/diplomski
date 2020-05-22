$(function() {
    $('#formId').submit(function(event) {
        event.preventDefault(); // prevent this form from being submited
        var userJson = JSON.stringify(jQuery('#formId').serializeArray());
        $.ajax({
            type: "POST",
            url: "/Path/To/Your/Web/Service",
            data: userJson,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){
                 alert(data);//handle it in a proper way
            },
            failure: function(errMsg) {
               alert(errMsg);//handle it in a proper way
            }
        });
        return false;
    });
});