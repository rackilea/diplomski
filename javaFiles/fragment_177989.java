.done(function(data){
    if(data.length != 0) {

   var $newRow = $("<tr>");
   var $newTextbox = $('<input type="text" id="'+data.item_key.nome+'" name="foo">');
   var $newButton = $('<button type="button" id="excluir_campo_'+data.item_campo.id+'" class="btn btn-link">Excluir</button>');

   $newRow.append($('<td>').append($newTextbox));
   $newRow.append($('<td>').append($newButton));

   $("table.campos").append($newRow);
   $("input[name=nome_campo]").val("");
 }
else {
    alert("erro ao incluir campo");
   }
})