@RepositoryRestController
public class ReportRepositoryController {

    @Inject
    private IReportRepository repository;

    @RequestMapping(method = RequestMethod.GET, value = "/ces/data/reports/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteReport(@PathVariable Long id) {
        repository.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}