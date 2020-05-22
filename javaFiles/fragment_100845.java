$(document).ready(function() {
    $("#login-form").on("submit", function(e) {
        e.preventDefault();
        var name = $('#name').val();
        var email = $('#email').val();

        var request = $.ajax({
            method: "POST",
            type: 'POST',
            dataType: 'jsonp',
            url: 'http://localhost:8080/AppBot/AnswerHandler',
            //pass your data as an array
            data: { operation : 'login', name : name, email: email },
            beforeSend: function ( xhr ) {
                //$('#loading').show();
            }
        });

        request.done(function( response ) {                

            console.info('Success');
            console.log(response);
        });

        request.fail(function( jqXHR, textStatus ) {
            alert( "Color request failed: " + textStatus );
            window.location.href = 'https://www.google.com';
        });


    });
});