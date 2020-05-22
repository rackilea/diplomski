$.ajax({
        type: "POST",
        url: "https://video.google.com/timedtext?lang=en&v=5MgBikgcWnY"
    }).done(function (response) {
        console.log(response);
    }).fail(function (response) {
        console.log();
    });