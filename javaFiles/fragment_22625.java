@RestController
@CrossOrigin(origins = "${crossOrigin}")
@RequestMapping("/api.spacestudy.com/SpaceStudy/Admin/Account")
public class AccountController {

    @Autowired
    AccountService accService;

    ...
}