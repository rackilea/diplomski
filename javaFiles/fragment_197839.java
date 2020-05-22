$("#secondSubmitButton").click(function(e){

 // let's stop default action first
  e.preventDefault();
  
  $("#yourForm").attr('action', 'http://yournewsubmiterl.com/somelink.php').submit();

});