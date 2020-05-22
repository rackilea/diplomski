$(document).on('keyup', 'input', function(){
   if($(this).val().length >= $(this).attr('maxlength'))
   {
       $(this).nextAll('input:first').focus();
       // OR even
       // $(this).next('input').focus();
   }
});