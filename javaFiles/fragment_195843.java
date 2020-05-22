@RestController
@RequestMapping("/api/aggreg")
public class AggregRestController  {

    @GetMapping("/list")
    public Map<String, List<AggregCalcTrainsXCompany>> aggregList  ()
            throws IOException, URISyntaxException, DataAccessException, SQLException {
        Map<String, List<AggregCalcTrainsXCompany>> m = new HashMap<>();
        m.put("data", aggregService.findAll());

        return m;
    }
}