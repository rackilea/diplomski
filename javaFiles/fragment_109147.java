//This is called after the DOM is fully loaded
$(function() {
   $("#mySubmitId").click(function(evt){
       //Prevent the default submit
       evt.preventDefault();
       //call the submit funtion
      submitData();
   });
});

function submitData()
{
    var dataObj = new Object();
    dataObj.email = $("#email").val();
    dataObj.password = $("#passord").val();

    $.ajax({
    url : '/registration',
    dataType : 'json',
    contentType : 'application/json; charset=UTF-8',
    type : 'POST',
    data: JSON.stringify(dataObj),              
    beforeSend : function(){
        //do something before send (e.g. show a message like: please wait)
    }); 

    },
    complete   : function(){
        //do something after sent (e.g. remove the message please wait)
    },
    success : function(data) {
        //handle the success response 
    },
    error : function(data) {
        //handle the error response 
    }
    });
}