$.ajax({
        url : "/servisDetail/uploadSoubor",
        type : 'GET',
        dataType: 'json',
        contentType: 'application/json',
        data : {
            fileSize: files.size,
            fileName: files.name,
            url: url
        },         
        success : function(response) { 
            console.log(response);
            vypisPrilohy(response);
        },
        error: function (xhr) { }
    });