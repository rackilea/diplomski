function GetInfoDivision()
{
     var data = $("#storeName").val();
    $.ajax({
        type : "POST",
        contentType : "application/json",   
        url : "hello" + "?storeName=" + data,
        dataType : 'json',              
        //timeout : 100000, 
        success : function(map) {
            console.log("SUCCESS: ", data);
            display(data);
        },
        error : function(e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });