@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @Autowired
    private WorkspaceRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    void save( @RequestBody String workspaceHTML) {
        Workspace ws = new Workspace();
        ws.setHTML(workspaceHTML);
        repository.save(ws);
    }
}