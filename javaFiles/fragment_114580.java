@RequiredArgsConstructor
@RestController
public class SearchController {

    @PostMapping(value = "/search", produces = {APPLICATION_JSON})
    public SearchResponse search(@Valid @RequestBody SearchRequest request,
                                          Pageable pageable) {
    }

    @PostMapping(value = "/search", produces = {TEXT_CSV})
    public ResponseEntity<Resource> export(@Valid @RequestBody SearchRequest request, Pageable pageable) throws IOException {

    }


}