@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String createUser(@Valid @RequestBody User requestUserDetails) {
        User user = requestUserDetails;

        if(requestUserDetails.getId() != null) {
            Optional<User> userOpt = userRepo.findById(requestUserDetails.getId());
            if (userOpt.isPresent()) {
                user = userOpt.get();
                // the user exists... do something..
            }
        }

        // at the end, save the user anyway (event if it exists or not)
        userRepo.save(user);
        return "The message delivered.";
    }
}