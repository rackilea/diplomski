$.ajax({
    url : "some.action",
        data : {
            "query" : inputText
    },
    type : 'GET',
    dataType : 'json',
success : function(data) {
    //code
},
error : function(data) {
    if (data.status == 401 ){
        console.log("UnAuthorized. Redirecting to Error");
        window.location.replace(contextPath +"/error.jsp");
    }
}