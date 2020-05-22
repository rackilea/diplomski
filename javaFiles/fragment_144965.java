$(document).ready(function() {
    $("#checkindate").change(function(event) {
        var selectedDate = event.target.value;

        $.get("/your/server/function?selectedDate=" + selectedDate, function(data) {
            // populate list with data
        }, "json");
    });
});