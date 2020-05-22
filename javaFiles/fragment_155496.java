@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public List<User> getUserByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        logger.info("Request to get user with email and password: " + email + password);
        User user = userService.checkUserByEmailAndPassword(email, password);
        return user != null ? Collections.singletonList(user) : Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUserByEmail(@RequestParam("email") String email) {
        logger.info("Request to get user with email: " + email);
        UserDto userDto = userService.checkUserEmail(email);
        return userDto != null ? Collections.singletonList(userDto) : Collections.emptyList();
    }

 }