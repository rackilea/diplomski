$(function(){
  $('.changeImage').hover(function(){
         $('.bottle').attr('src',$(this).attr('data-src'));
         $('.bottle').show();
     },
     function(){
         $('.bottle').hide();
     });

})