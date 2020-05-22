$.ajax({
        url : "myController",
        type: "POST",
        data:{"name": $("#name").val()},
        success : function(result) {                       
                 alert(result);
               }

       });