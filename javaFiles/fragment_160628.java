new Ajax.Request(
    '/orders/check_first_last/A15Z2W2', 
    {
        asynchronous:true,
        evalScripts:true, 
        parameters:
        {
            first:$('input_initial').value, 
            last:$('input_final').value, 
            order_quantity:$('input_quantity').value
        },
        onSuccess: function(transport) 
        {
             $('result_text').update(transport.responseText);
        }
    }
);