$(document).ready(function()
    {
            var $ul = $(SALUTATION);
            $.get('MyServletName?action=cmbSALUTATION', function(responseJson) 
            {
                $.each(responseJson, function(index, item)
                { 
                    $('<option value=' + item +'>').text(item).appendTo($ul);
                });
 setValSALUTATION(); 
            });

    });

function setValSALUTATION()
{
        $.get('ProfileContactsMain?action=cmbSALUTATIONValue', function(responseJson)
        {
            $.each(responseJson, function(index, item) 
            {
            $("#SALUTATION").val(item);
            });
        });
}