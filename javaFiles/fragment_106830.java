$.ajax({
        crossDomain: true,
        type:"GET",
        contentType: "application/json; charset=utf-8",
        url: "http://www.helloWorld2.com/servlet?callback=?",
        data: {projectID:1},
        dataType: "jsonp",                
        jsonpCallback: 'fnsuccesscallback'
    });