$(function() { 
  $("#Combobox1").on("change",function() { 
  alert();
    $("#userName").val($(this).val()); 
  }); 
});