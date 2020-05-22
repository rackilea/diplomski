$.get("/blobUrl", function(data){
    $("#changeProfilePictureForm").attr('action', data);
    $("#changeProfilePictureForm").submit();
    $("#changeProfilePictureForm").hide();
    $("#loadingImg").show();
});