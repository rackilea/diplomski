@RestController
@RequestMapping("thing")
public class ThingController {

    @RequestMapping(value = "/{thingName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getThing(
            @PathVariable(value = "thingName") String thingName) {
        return "foo";
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getThings(
            @RequestParam(value = "findByComponent", required = false) String findByComponentQuery) {
        return "bar";
    }
}