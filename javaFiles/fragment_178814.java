$(document).ready(function(){
    var dueDate = new Date("8/15/2015");
    var today = new Date();
    if(today > dueDate){
        $("#preferredFirstName").prop("disabled", "disabled");
        $("#preferredLastName").prop("disabled", "disabled");
    }
});