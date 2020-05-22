@RestController
@RequestMapping("/personAffiliations")
public class PersonAffiliationsRestController {
   @RequestMapping(value = "/getOrgsViaAjax", method = RequestMethod.GET)
   public @ResponseBody String getOrgsViaAjax(@RequestParam("term") String query) {
     return "{\"Test OrgOne\":\"42695847\",\"Test OrgTwo\":\"84920493\",\"Test OrgThree\":\"22222222\",\"Test OrgFour\":\"42226589\"}";
   }
}