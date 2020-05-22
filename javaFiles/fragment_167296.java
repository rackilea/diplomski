function() {
    if ($("#product_category").val() == 'Others') {
        $('#product_category').prop('disabled', true); // disabled
        $('#new_product_category').prop('disabled', false);
    } 
    //else {
        //$('#new_product_category').prop('disabled', 'disabled');
       // $('#product_category').prop('disabled', false);
       // $('#new_product_category').prop('disabled', true); //disabled
    //}
};