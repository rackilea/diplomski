$.ajax({
    method : "get",
    url : "rest",
    dataType : 'text',
    success : function(data) {
        console.log(data);
    },
    error : function(e){
        console.log(e);
    }
});