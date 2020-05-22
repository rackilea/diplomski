<script>
    $("#myUL").click(function(){
        var username=$('#username').val();
        $.ajax({
            url: "details",
            type: 'POST',
            data: {username:username},
            success: function(data) {
                         $("#card").html(data);
            }
        });
    });
</script>