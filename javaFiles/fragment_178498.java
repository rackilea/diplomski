@RequestMapping(value = "/imageController/{imageId}")
@ResponseBody
public byte[] helloWorld(@PathVariable long imageId)  {
  Image image = //obtain Image instance by id somehow from DAO/Hibernate
  return image.getData();
}