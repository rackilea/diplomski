$.ajax({ 
    url: "/MyApp/rest/display", 
    success: function(data) {
        $.each(data, function(i,service) {
            $("#service").append('<p>'+service+'</p>');
        });}, 
    dataType: "json" });