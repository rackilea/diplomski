@RestController
@RequestMapping("/account")
class UserRestFullEndPoint {

    @GetMapping("/userInfo")
    public Principal userInfo(Principal principal){
        return principal;
    }
}