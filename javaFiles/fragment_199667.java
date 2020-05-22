jQuery.ajax(
        {
            type: 'GET', 
            url: '/proj/getData?id='+$('#id').val(), 
            //data: {id: $('#id').val()},
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: function(data){         
                alert(data.result);

             },
             error: function(XMLHttpRequest, textStatus, errorThrown){
                 alert('Error ' + textStatus);
                 alert(errorThrown);
                 alert(XMLHttpRequest.responseText);
             }
        });