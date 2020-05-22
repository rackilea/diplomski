$(".confirmImgBtn").click(function(eve) {
    var field1 = $("#imgTable tbody>tr:last #field1").val();
    var field2 = $("#imgTable tbody>tr:last #field2").val();
    var form = $('#confirmImgForm');
    var newfile = $("#imgTable tbody>tr:last #imgFile")[0].files[0];
    var formdata = false;
    if (window.FormData) {
        formdata = new FormData();
    }
    if ( window.FileReader ) {
        reader = new FileReader();
        reader.onloadend = function (e) {
            //showUploadedItem(e.target.result, file.fileName);
        };
        reader.readAsDataURL(newfile);
    }
    if (formdata) {
        formdata.append("image", newfile);
        formdata.append("field1",field1);
        formdata.append("field2",field2);
    }
    if (formdata) {
        jQuery.ajax({
            url: form.attr('action'),
            type: "POST",
            data: formdata,
            processData: false,
            contentType: false,
            success: function (res) {
                alert('succeed!!');
            }
        });
    }
});