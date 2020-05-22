$(".addImgBtn").click(function() {
        $('#imgTable tbody>tr:last').clone(true).insertAfter('#imgTable tbody>tr:last');
        $("#imgTable tbody>tr:last #field1").val('');
        $("#imgTable tbody>tr:last #field2").val('');
        $("#imgTable tbody>tr:last #divFile").show();
        $(".addImgBtn").attr("disabled", "true");
        return false;
    });