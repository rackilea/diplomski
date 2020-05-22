// Ajax refresh price value.
setInterval(function() {
    $.ajax({
        url:"query.php?currency=<?=$currencycode;?>"
    }).done(function(data) {
        $("#value").attr("value", data).attr("size", data.length);
    });
}, 3000);