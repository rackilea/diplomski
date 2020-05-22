function redFun() {
    $.ajax({
        type: "GET",
        url: "/HelloWeb/redirect"
    }).fail(function (jqXHR, status, err) {
        if (jqXHR.status === 302) {
            window.location = jqXHR.getResponseHeader('Location');
        }    
    });
}