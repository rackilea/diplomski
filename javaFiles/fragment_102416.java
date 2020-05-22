$(document).ready(function () {
    $('#sala').change(function (event) {
        var name = $('#sala').val();
        $.post('../EditarSala', {
            sala: name
        }, function (responseText) {
            $('#resultado').html(responseText);
        });
    });
});