hidden_canvas.toBlob(function(blob) {
    var fd = new FormData();
    fd.append('fileName', 'testBlob.png');
    fd.append('data', blob);
    sendAJAXFileUploadRequest(fd);
},'image/png');

function sendAJAXFileUploadRequest(formData) {
   $.ajax({
       type: 'POST',
       url: servicePath + "upload",
       xhrFields: {withCredentials: false},
       headers: {},
       data: formData,
       processData: false,
       contentType: false,
       success: function(data, status, xhttp) {
           alert(data);
       },
       error: function() {
           alert("Error uploading snapshot file to server!");
       }
   });          
}