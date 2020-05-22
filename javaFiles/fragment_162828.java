$('.del-btn .userId').click(function(){
    var userId = $(this).attr("alt");

    $.ajax({
        url: 'deleteUser',
        data: ({
                userId : userId,
            }),
        success: function(response) {
            alert(response)
        }
    });
});