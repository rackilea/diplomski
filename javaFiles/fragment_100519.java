function onButtonClick(){
   $.ajax({         
            type:       "post", //method type
            dataType:   "json", //response data type
            url:        ajaxUrl, //your webservice URL
            data:       "jsonobj", // Data to be send to server
            success:    function(response)  // call back function after get successfull responce
            {  
               // Process JSON response here  

            }  
      });    
 }