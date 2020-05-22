$.ajax({
    method : "get",
    url : "rest",
    dataType : 'text',
    data : {"name" : "some name"},
    success : function(data) {
        console.log(data);
    },
    error : function(e){
        console.log(e);
    }
});