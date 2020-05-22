$("#result").on("click", ".some", function (event) {
    event.preventDefault();
    var $td = $(this).parent();
    var phaseid = $td.siblings('.phase').text();
    var userid = $td.siblings('.users').text();
    alert(userid + " " + phaseid);
});