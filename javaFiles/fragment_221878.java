$(document).ready(function() {
    //toggle `popup` / `inline` mode
    $.fn.editable.defaults.mode = 'inline';     

    //make username editable
    $('.username').editable({

    //uncomment these lines to send data on server
        id: 'id',
        id2: 'id2',
        url: './ajax_editor.php'

    });
});
</script>