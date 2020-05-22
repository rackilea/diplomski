@Controller
@Scope("session")
@RequestMapping("/")
public class DomainController {
    @Autowired
    CountSelectionBean domainCountBean;