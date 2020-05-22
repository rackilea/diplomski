$('#empId').change(function() {  
    $.ajax({
            type: 'POST',
            dataType: 'json',
            url: 'your_url', // in your controller side (RequestMapping value)
            data: 'empId='+$('#empId').val(),
            success: function(responseData, textStatus) {
                // your stuff here. you found the response in responseData var.
            },
            complete: function(textStatus) {

            },
            error: function(responseData)
            {

            }
    });
});