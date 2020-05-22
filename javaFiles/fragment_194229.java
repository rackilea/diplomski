@RestController
@RequestMapping("items")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {

    private final ItemResourceProcessor resourceProcessor;

    @RequestMapping(method = GET)
    public ResponseEntity<List<Resource<Item>>> getAll() {
        List<Resource<Item>> items = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            items.add(resourceProcessor.process(
                    new Resource<>(new Item(i, UUID.randomUUID().toString()))));
        }

        return ResponseEntity.ok(items);
    }

    @RequestMapping(method = GET, path = "/{id}")
    public ResponseEntity<Resource<Item>> getOne(@PathVariable Integer id) {
        return null;
    }
}