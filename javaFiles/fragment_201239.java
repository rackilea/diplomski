function formSubmit() {
    $.ajax({
        type : "POST",
        url : 'rest/user',
        contentType : 'application/json',
        //dataType : 'json',
        data : $('#form1').serialize(),
        success : function(data) {
            doAjax();
        }
    });
}