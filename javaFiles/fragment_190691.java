@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @RequestMapping("/{userId}")
    //public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        return Collections.singletonList(
                new CatalogItem("transformers", "Test", 4)
        );
    }

}