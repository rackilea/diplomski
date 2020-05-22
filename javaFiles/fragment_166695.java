@RestController
@Validated
public class Ctrl {
    // ...
    @GetMapping("/{id}")
    public String getById(@Pattern(regexp = REGEXP) @PathVariable String id) {
        return someObjectService.getById(UUID.fromString(id)));
    }

}