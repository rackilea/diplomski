@RequestMapping(value = "/{whichOne}")
public class someController {
    @RequestMapping
    public ResponseObject someMethod(@PathVariable("whichOne") String whichOne) {
        switch (whichOne) {
            case "jobs":
                return resolveJobs();
            case "subs":
                return resolveSubs();
        }
    }
}