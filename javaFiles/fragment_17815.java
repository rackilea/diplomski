sending: function(file, xhr, formData) {
    //Execute on case of timeout only
    xhr.ontimeout = function(e) {
        var errorMessage = "The server timed out transferring file " + file.name + ". Please try again or contact your administrator.";
        $("#dropzone-error-messsage-block").append("<span>" + errorMessage + "</span>");
    };
    formData.append('fullPath', file.fullPath);
}