@PostMapping("/uploadTestEntity")
public String uploadTestEntity(
@RequestParam("addClient") String clientNameEntityNew,    
@RequestParam(value = "image") MultipartFile image) {
  try {
      ObjectMapper mapper = new ObjectMapper();
      testEntity testEntity = mapper.readValue(clientNameEntityNew,testEntity.class);
      testEntity.setImage(image.getBytes());
      TestEntityService.save(testEntity);
    return "File uploaded successfully! -> filename = "+ image.getOriginalFilename();
      } catch (  Exception e) {
  return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
}    
}