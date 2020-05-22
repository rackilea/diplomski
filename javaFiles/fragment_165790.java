$('.btn-delete').click(function () {
    var id = //get the id somehow
    doAjaxDelete(id);
});

function doAjaxDelete(id){      
     $.ajax({
            type: "DELETE",
            url: "your/path/to/record/" + id,
            success: function(response){
                // we have the response, do something to notify success
            error: function(e){
                //do something to notify failure
            });
   }