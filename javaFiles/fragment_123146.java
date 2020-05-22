$(function() {
    $(".inputField").each(function() {
        $(this).val(localStorage.getItem($(this).attr("id")));
    });
    $(".inputField").keyup(function() {
        localStorage.setItem($(this).attr("id"), $(this).val());
    });        
});