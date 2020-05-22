@RestController
public class nameController {    

    @Resource
    private ServletContext servletContext;

    @RequestMapping(value = "/getImage/{img_name:.+}")
    public byte[] getImage(@PathVariable String img_name) throws InternalError  {
    byte[] data;

     try {
         String imageFolder = servletContext.getInitParameter("imageFolder");

         String realpath = imageFolder + img_name;
         Path path = Paths.get(realpath);
         data = Files.readAllBytes(path);
     }catch (Exception e){
         data = null;
     }
    return data;
   }
}