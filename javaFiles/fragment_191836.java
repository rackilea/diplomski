@RestController
@RequestMapping("/test")
public class TestController {

    private TestClass testClass;

    TestController(TestClass testClass) {
        this.testClass = testClass;
    }

    @RequestMapping("/{propName}")
    public String test(@PathVariable String propName) {
        return testClass.test(propName);
    }

}