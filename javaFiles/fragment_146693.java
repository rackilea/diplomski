@Controller
@RequestMapping("/widget")
public class WidgetRestService {

    /**
     * @return All the widgets info.
     * @uri http://localhost:8888/rest/widget/
     */
    @RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
    public @ResponseBody String getAll() {
        return Arrays.asList(new Widget("BuyerApp", "Buy something now!"), new Widget("DogSwitcher", "Tired of your dog? Switch it right now!"));    
    }
}