$('select').val(3);

$('select').on('change', function(){
var str="";
$( "select option:selected" ).each(function() {
      str = $( this ).attr('data-matr') + " ";
    });

$('#result').val(str);
});