$(document).ready(function(){ 
  $("#btn").click(function(event){ //note "click" instead of "ready"
    event.preventDefault(); //stop default postback behaviour so we can use ajax
    var data1 = new FormData($("#formId")[0]);

    $.ajax( {
      url: 'Sample1',
      type: 'POST',
      data :data1,
      processData: false,
      contentType: false,
      dataType:"text",
      success:function(response)
      {  
      }
    }); 
  });
});