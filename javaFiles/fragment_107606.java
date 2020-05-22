$('#wizard').tabs({ disabled: [1] });

// when checkbox is clicked
$('#terms').click(function() {
    // is checkbox checked
    if ($(this).is(':checked')) {
        // enable tab 1
        $('#wizard').tabs('enable', 1);
        // select tab 1
        $('#wizard').tabs('select', 1);
    } else {
        // disable tab 1
        $('#wizard').tabs('disable', 1);
    }
});