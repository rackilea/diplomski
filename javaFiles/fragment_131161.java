@CrossOrigin
@RestController
@RequestMapping("/fixing")
public class FixingController {

    /**
     * Builds a list of Fixing strings from the database
     * @return list
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<String> getAllFixingsViaRestController() {

        final List<String> fixingList = new ArrayList<>();
        fixingList.add("foo");
        fixingList.add("bar");

        return fixingList;
    }

}