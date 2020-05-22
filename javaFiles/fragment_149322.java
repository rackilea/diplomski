Gallery.prototype.upload = function(base64, imageName) {

var galleryObject = this;
galleryObject.loadingCallback(true);

var request = new FormData();                   
request.append("imageBase64", base64.match(/,(.*)$/)[1]);
request.append("imageName", imageName);

$.ajax({url:this.urlBase + "/upload",
    data: request,
    type: "POST",
    processData: false,
    contentType: false,
    success: function(result)
        {
            galleryObject.handlerErrorMessageCallback();
            galleryObject.loadingCallback(false);
            galleryObject.refreshImageGalleryCallback();
        }
}).fail(function() {
    galleryObject.handlerErrorMessageCallback("error.upload.image");
    galleryObject.loadingCallback(false);
});
}