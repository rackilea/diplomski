$.ajax({
        url: "/entries/" + id,
        contentType: "application/json",
        type: "PUT",
        dataType: "json",
        data: JSON.stringify({'name' : name, 'date': date}),
        success: function(msg) {
            console.log('updated...')
            $.mobile.changePage($('#list'));
        }