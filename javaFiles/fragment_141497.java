// delete the user from the database
function removeUser(deleteURL) {

    $.ajax({

        type: "DELETE",
        url: deleteURL,

        success: function () {
            // window.location.reload();
             $('#myTableRow').remove();
        },

        failure: function (errMsg) {
            console.log(errMsg.toString())
        }
    });
}