$(document).ready(function() {

    // If you want the option's text.
    $('.select-field').on('change', function() {
        $('p').text("You selected " + $(this).find('option:selected').text()));
    })

    // If you want the option's value.
    $('.select-field').on('change', function() {
        $('p').text("You selected " + $(this).val()));
    })
})