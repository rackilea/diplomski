// when checkbox is clicked
$('#terms').click(function() {
    // is checkbox checked
    if ($(this).is(':checked')) {
        // select tab 1
        $('#wizard').tabs('select', 1);
    }
});