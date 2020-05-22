$.ajax({
    type: 'POST',
    url: '/recognizeCommand',
    data: data,
    dataType: 'json',
    processData: false,
    contentType: false,
    beforeSend: function(xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
        },
    success: function(data) {
      alert("works!");
    },    
    error: function() {
      alert("not works!");
    }
})