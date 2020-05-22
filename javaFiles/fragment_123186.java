function getUnits(theUrl){
 $.ajax({

   url: theUrl,
   success: function(returndata){
     alert(returndata);
   }
 });
}