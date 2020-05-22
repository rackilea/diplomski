$.getJSON('myservlet', function(data) {
    var table = $('<table>').appendTo($('#data'));
    $.each(data, function(i, product) {
        var row = $('<tr>').appendTo(table);
        $('<td>').text(product.id).appendTo(row);
        $('<td>').text(product.name).appendTo(row);
        $('<td>').text(product.description).appendTo(row);
    });
});