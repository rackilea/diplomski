function APICall(url, methodType, data) {
    var d = $.Deferred();
    methodType = methodType || "GET";
    data = data || null;
    $.ajax({
        url: url,
        async: true,
        method: methodType,
        data: data,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response, status, request) {
            d.resolve(response, status, request);
        },
        error: function (error) {
            d.resolve(error.responseJSON);
        }
    });
    return d.promise();
}
APICall(url, methodType, data).done(function (response, status, request) {
    d.resolve(response, status, request);
}).fail(function (response) {
    d.resolve(response, status, request);
});