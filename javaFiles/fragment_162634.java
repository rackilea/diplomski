$(document).on('click', '.review_ratings_login', function () {
        var $data = $('#review_product_id span').text();
         var url = '/mycompany/login/'+$data;
        $.ajax({
            type: 'GET',
            url: url,
            success: function (output) {
            $('#login_for_review').html(output).modal('show');//now its working
            },
            error: function(output){
            alert("fail");
            }
        });
    });