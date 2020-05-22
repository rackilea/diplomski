@Controller
@RequestMapping("/apipath")
public class SomeController {
@RequestMapping(value = "/ajaxJsonPost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public String postJson(@RequestBody final Entity en) {
        System.out.println(en.toString());

        //assuming you have a class "EntityService" and 
        //it has a method postData 
        //which takes Entity object as parameter and pushes into database.
        EntityService.postData(en);

        System.out.println("added");
        return "success";
    }
}