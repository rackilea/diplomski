function myFunction() { 

  if(confirm("Are you sure you want to delete this?")){
      var activeRecord= '${id}';  //or get id from click function

     //Make sure it is having the value here.
     //alert(activeRecord); or console.log(activeRecord);

     $.ajax({
       type: "POST",
       url: "servletURL",
       data: {"id": activeRecord},   
       dataType: 'json',
       success: function(data){
           // use data for populate form
       }
     }); 
   }
   else{
      return false;
   }
}