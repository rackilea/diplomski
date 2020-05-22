$.ajax({
        type: 'POST',
        url: '/url?arr='+tdValues,
        error : function() {
            console.log("error");
        },
        success: function () {
            location.reload()
        }
    });