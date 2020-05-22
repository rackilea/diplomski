@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
public Test update(
        @Size(min = 1) @RequestBody List<String> ids,
        @Min(3) @PathVariable("id") String name) {
    return doSomething(ids, name);
}