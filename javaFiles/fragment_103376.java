$.ajax({
    url: '/YourServlet',
    type: 'POST',
    data: { value: $('#AceEditor'.val()) },
    success: function(result) {
        alert('the request was successfully sent to the server');
    }
});