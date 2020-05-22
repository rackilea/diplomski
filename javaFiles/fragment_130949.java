url: 'some_servlet',

   type: 'GET',

   data: your_query_object,

   success: function(response){

                          alert(response);

                      },

   error: function(reason){

                alert(reason);
              }