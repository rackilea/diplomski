@RestController
@RequestMapping(value = "/cs")
public class CsController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void processCsData(@RequestBody CsData csData) {
        processCsData(csData);
    }

}