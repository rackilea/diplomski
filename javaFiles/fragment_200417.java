$.ajax({
    url: 'sampleUrl.com/controller/call',
    dataType: 'json',
    success: function(data) {
        for(var i = 0; i < data.length; i++) {
            console.log(data[i]);
        }
    }
}