$("#names").change(function(){
  $("#ids").val($(this).val());
});

$("#ids").change(function(){
  $("#names").val($(this).val());
});