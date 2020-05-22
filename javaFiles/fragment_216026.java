$("#uploadForm").submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: 'upload.ajax.php',
        data: new FormData($(this)[0]),
        cache: false,
        contentType: false,
        processData: false,
        type: 'POST',
        success: function (data) {
           console.log(data);
        }
    }); 
});