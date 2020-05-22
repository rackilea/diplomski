$('.target1').change(function() {
    $.ajax({
        $('.target2').empty();
        url: 'http://localhost:8080/YourAppName/ServletName',
        data: {selectedValue: $(this).val()},
        success: function(response) {
            $('.target2').append(response);
        }
    });
});