$(document).ready(function() {
    $('.select-field').on('change', function() {
        var selectedOption = $(this).find('option:selected');
        var name = $(selectedOption).text();
        var id = $(selectedOption).val();
        var description = $(selectedOption).attr('data-description');
        var imageName = $(selectedOption).attr('data-image');
        // Find your image by id.
        var image = $('#myImage');

        // Set your new image.
        $(image).attr('src','/img/'+ imageName));
    })
})