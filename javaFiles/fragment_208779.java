$(document).ready(function() {
    $('.someName').click(function() {
        $.ajax({
            type: 'GET',
            url: $(this).attr('href'), // This sets the actual value of ${url}.
            success: function() {
                window.location.reload();
            }
        });
        return false; // Blocks link from executing the default href action.
    });
});