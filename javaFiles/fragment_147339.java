//JSON 
  var masterdata = new Object();
     masterdata.grn = $('#grn').val();
     masterdata.pono = $('#pono').val();
     masterdata.podt = $('#podt').val();
      
//call the servlet to insert the data only when error = 0
  if (error != 1){
   $.ajax({
    url : 'insertserv',
    type: 'POST',
    dataType: 'json',
          data: JSON.stringify({"test" :masterdata}),
          contentType: 'application/json',
          mimeType: 'application/json',
    success : function(data) {
       alert('Hi');
      }   
            });
      }
  else{
   alert("Save cannot be performed. Please check the entered data!");
  }
    });