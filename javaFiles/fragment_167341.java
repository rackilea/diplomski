$.ajax({
    type: "POST",
    url: url,
    data: params
}).done(function( data ) {
    showData(data,page);
}).fail(function(jqXHR, textStatus) {
    showFail(jqXHR, textStatus);
});