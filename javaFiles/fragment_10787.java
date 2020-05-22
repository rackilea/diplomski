@Controller
@RequestMapping("/post")
public class PostController {


    @RequestMapping(value= {"/{post}"})
    public ModelAndView postPage(@AuthenticationPrincipal User tempUser, @PathVariable("post") String tempPostName ) throws NotFoundException  {
        ...
    }

    @PostMapping("addcomment")
    @ResponseBody
    public String saveComment(@AuthenticationPrincipal User tempUser, @RequestParam("post_id") int id, @RequestParam("comment") String tempComment) {
        ...
    }       
}