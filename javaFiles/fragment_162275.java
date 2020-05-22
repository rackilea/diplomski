$.ajax({          
    type:"POST",
    url:"/check",
    data: {"email":"email@to.check.com"},
    success:function(responseData){
        alert("Inside Success");
        $('#resp email').html(responseData);
    }, 
   error: function(e){

   }        
});