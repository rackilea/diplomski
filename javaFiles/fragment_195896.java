@RooWebJson(jsonObject = Example.class)
@Controller
@RequestMapping("/example/")
public class ExampleController {
    @Resource
    ExampleRepository exampleRepo;

    @RequestMapping(method = RequestMethod.PUT, value ="/{name}")
    public void putExample(@PathVariable("name") String name) {
        exampleRepo.save(new Example(name));
    }
}