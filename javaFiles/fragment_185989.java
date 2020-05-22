@Controller
public class CampainController {

    @RequestMapping(name = "/test", method = RequestMethod.POST)
    @ResponseBody
    public CampaignDTO test(@RequestBody CampaignDTO campaignDTO) {
        return campaignDTO;
    }
}