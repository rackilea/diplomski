function myFunction(){
  jQuery.ajax({
   url:'path/to/java/method=with_some_parameters'
   async:false,
   success:function(data){
     document.open();
     document.write(data);
     document.close();
     //nested ajax

   }
  });
 }