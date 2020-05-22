function getMyImage() {
  jQuery.get(image_url, function(response) {
    jQuery('#img-name').attr('src', response);
    getMyImage();
  });
}