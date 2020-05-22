@Controller
    public class ApplicationController {
            @Autowired
            SpecialClaimsCaseManager caseManager;

            @RequestMapping(value="/test", method=RequestMethod.GET)
            public @ResponseBody Collection<SpecialClaimsCase> getCaseInJSON(@RequestParam Map<String, String> requestParams, ModelMap model) {
                ....
                return new ArrayList<SpecialClaimsCase>(caseManager.findAll());
            }
    }