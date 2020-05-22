@RequestMapping(method = RequestMethod.GET, params = {"id", "query"})
public A getA(@RequestParam int id, @RequestParam String query) {
    ...
}


@RequestMapping(method = RequestMethod.GET, params = {"id"})
public A getA(@RequestParam int id) {
    ...
}