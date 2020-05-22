@Controller
@RequestMapping("/user")
public class UserController{
    @RequestMapping(value = "/profileImage", method = RequestMethod.POST)
    public  @ResponseBody String imageUploader(@RequestParam("image") MultipartFile image, @RequestParam String name)throws Exception{
        return "";
    }
}