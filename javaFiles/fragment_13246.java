$('#btn_confirm').click(function (e) {

    e.preventDefault();     // do not submit the form

    // prepare the array
    var data = table.rows('.selected').data();
    var ids = [];
    for(var i = 0; i < data.length; i++) { 
        ids.push(Number(data[i][0]));
    }

    $.ajax({
        type: "POST",
        url: "?confirm",
        data: JSON.stringify(ids),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){
            alert(data);
        },
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
});