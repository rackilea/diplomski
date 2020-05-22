$('#add_product_button').click(function()
{
        var description = $("#description").val();
        $("#hidden_description").val(description);
        $("add_product_form").submit();
});