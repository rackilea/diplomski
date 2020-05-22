$http.post("<SERVER_URL>", "<PARAMS_IF_ANY>", {
    responseType:'arraybuffer'
}).success(function(data, status, headers) {
    var contentType = headers["content-type"] || "application/octet-stream";
    var urlCreator = window.URL || window.webkitURL || window.mozURL || window.msURL;
    if (urlCreator) {
        var blob = new Blob([data], { type: contentType });
        var url = urlCreator.createObjectURL(blob);
        var a = document.createElement("a");
        document.body.appendChild(a);
        a.style = "display: none";
        a.href = url;
        a.download = "download.pdf"; //you may assign this value from header as well 
        a.click();
        window.URL.revokeObjectURL(url);
    }
}