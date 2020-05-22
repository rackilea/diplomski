error: function (theRequest,textStatus, errorThrown) {
                          alert (theRequest.responseText);
                          alert(errorThrown);
                },

  success: function (data) {

                var result=data;
                alert(result);
        }