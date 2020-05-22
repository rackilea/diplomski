@RestController
public class SampleController {

    @GetMapping
    public Sample get() {
        Sample s = new Sample();
        s.setProperty("Some Property");
        return s;
    }

}