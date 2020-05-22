$(document).ready(function() {
    $('#buttonId').click(function() {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/register",
            success : function(data){
                console.log(data);
            },
            data : {
                user : 'test.user@acme.com',
                password : 'password'
            }
        });
    }
}