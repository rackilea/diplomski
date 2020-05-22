$(function() {
    var loadr = new Image();
    $(loadr).load(function() {
        $("#myimg").attr("src", this.src);
    });
    loadr.src = "servletUrl";
});