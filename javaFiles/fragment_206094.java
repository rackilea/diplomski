function yourFunc() {


    $.ajax({
        type : 'POST',
        url : 'yourcontroller/action',
        contentType : "application/json; charset=utf-8",
        dataType : 'json',
        data : param,
        async : false,
        cache: false,
        success : function(dataList) {
            //alert("dataList ---> "+dataList); 



        },

        error : function(XMLHttpRequest, textStatus, errorThrown) {
            //alert(XMLHttpRequest + " - " + errorThrown);
        }
    });


}