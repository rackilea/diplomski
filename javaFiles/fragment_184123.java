$(document).ready(function() {
$('[name="apple"], [name="cat"]').prop('checked', true);

$('[name="startall"]').on('click', function() {
    var $checkboxes = $('input[type="checkbox"]').not('[name="startall"], [name="stopall"]');
    if (this.checked) {
        $checkboxes.prop({
            checked: true,
            disabled: false
        });
        $('#textbox').val( $(this).attr('data-name'));
    }
    else{
         $checkboxes.prop({
            checked: false
        });
         $('#textbox').val('');
    }
});

$('[name="stopall"]').on('click', function() {
    var $checkboxes = $('input[type="checkbox"]').not('[name="startall"], [name="stopall"]');
    if (this.checked) {
        $checkboxes.prop({
            checked: false,
            disabled: true
        });
        $('#textbox').val( $(this).attr('data-name'));
    }
    else{
         $checkboxes.prop({
            disabled: false
        });
        $('#textbox').val('');
    }
});