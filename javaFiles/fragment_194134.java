@RequestMapping("/image/{personId}")
@ResponseBody
public HttpEntity<byte[]> getPhoto(@PathVariable String personId) {
    byte[] image = org.apache.commons.io.FileUtils.readFileToByteArray(new File([YOUR PATH] + File.separator + personId + ".png"));

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_PNG); 
    headers.setContentLength(image.length);
    return new HttpEntity<byte[]>(image, headers);
}