$('*').filter(function() {
if ($(this).css('position') === 'fixed'){
   $(this).css('position', 'relative');
}

});