$(".delete-button").on("click", function() {
    var wordId = $(this).attr("id").substring("delete_".length);
    $.ajax({
        type: "DELETE",
        url: "/word/" + wordId,
        success: function() {
            // Maybe put some code here that deletes the <li> ?
        }
    }); 
});