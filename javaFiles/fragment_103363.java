<script>
    $.getJSON('someurl', function(data) {
        $.each(data, function(index, command) {
            alert(command.sequence + "," + command.rule);
        });
    });
</script>