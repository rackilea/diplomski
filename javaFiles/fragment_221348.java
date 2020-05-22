@RestController
class Controller {

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public Response createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}