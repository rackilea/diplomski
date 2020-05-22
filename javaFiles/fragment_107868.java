$(function(){
   $('#select-choice-1').change(function(){
      var sel = $(this).val();
      $('#select-choice-2').val(sel.toUpperCase());
   });
 });