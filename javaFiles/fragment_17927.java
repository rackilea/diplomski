$('#test').on("submit", function (e) {
    e.preventDefault();
    $.post(this.action, function(data) {
        console.log(data);
    });
});