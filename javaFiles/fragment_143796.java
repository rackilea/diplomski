jsRoutes.controllers.Application.receiveData().ajax({
        data:outputData,
        dataType: 'text',
        contentType:'application/json',
        success: function(data) {
          console.log(data);
        },
        error: function() {
          alert("Error!");
        }
      });