@Controller
public class SearchEntityController {

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public void searchForm(Model model) {
    model.addAttribute(new Search());
  }

  @RequestMapping(value = "/entitydemo", method = RequestMethod.POST)
  public void showSearchResult(@ModelAttribute Search search, Model model) {
    model.addAttribute("entityDemo", getEntityDemo(search));
  }

  // code to load entity here
}