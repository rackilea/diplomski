@RequestMapping("/api/cars/")
public class BaseCarController {
    @GetMapping("/common")
    public String common() {
        return "Common stuff";
    }
}