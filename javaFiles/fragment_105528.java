//<table id="game-list">
$("#game-list").on('click','.js-delete-game',function(event){
    var id = $(event.target).data('gameId'); //data-game-id Get your unique game ID from the clicked button.
    var data = JSON.stringify({"id":id});
    var rowId= "#"+event.target.id; //get button id from clicked button and create selector
    $.ajax({
    type : "DELETE",
    url : "${pageContext.request.contextPath}/deleteGame",
    contentType: "application/json",
    data : data,
    success: function(data){
       //remove row deleted on page without refreshing.
       $(rowId).closest('tr').remove();
    }
    });
});