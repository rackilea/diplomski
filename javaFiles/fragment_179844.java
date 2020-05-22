function validator() {
    $.ajax({
        url: 'validator.jsp',  // Change the relative path if needed 
        type: "GET", // This is optional and defaults to GET as well
        error : function(){ 
            console.log('Error in the AJAX call'); 
        },
        success: function(msg){      
                console.log(msg);
        }
}