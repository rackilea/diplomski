$(function(){
    $("#portfolio img").click(function(){
        var src = $(this).attr("src");
        $("#frame").next('img').attr("src", src);// use next to get image
        $("#frame").fadeIn();
        $("#overlay").fadeIn();
    });
});