@RequestMapping(value = "/getphoto", method = RequestMethod.GET , produces = MediaType.IMAGE_JPEG_VALUE)
public ResponseEntity<?> getphoto(@RequestParam(@RequestParam("uuid") UUID uuid) {
    byte[] image = service.getPhoto(uuid);
    ResponseEntity<?> responseEntity = null;
    if(image == null)
        responseEntity = ResponseEntity.notFound().build();
    else
        responseEntity = ResponseEntity.ok(image);
    return responseEntity;
}