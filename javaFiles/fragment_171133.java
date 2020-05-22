@PostMapping("/uploadTestEntity")
public String uploadTestEntity(
         @RequestParam("clientName") String clientName ,
         @RequestParam("lastName") String lastName
         @RequestParam("age") String age
        ,@RequestParam(value = "image") MultipartFile image) {
  try {

      testEntity testEntity = new testEntity();
      testEntity.setImage(image.getBytes());
      testEntity.setClientName(clientName);
      testEntity.setLastName(lastName);
      testEntity.setAge(age);
    return "File uploaded successfully! -> filename = "+ image.getOriginalFilename();
} catch (  Exception e) {
  return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
}    
}