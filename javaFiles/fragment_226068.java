@SpringBootApplication
@RestController
public class MyApplication {
    [...]
    @RequestMapping(value="/createProject", method=RequestMethod.POST)
    public String createProject(@RequestBody final String name) {
        System.out.println("createProject, server side, name: " + name);
        return "";
    }   
}