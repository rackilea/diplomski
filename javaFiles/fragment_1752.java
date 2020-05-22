success: function (responseText) {
    if (responseText != 'failure')
        // make sure you provide the correct URL from the server
        window.location = responseText;
    else
        $('#failedText').text('Invalid Username or password');
}