@RequestMapping(value = "thing/{thingName}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public String getThing(
        @PathVariable(value = "thingName") String thingName,
        @AuthenticationPrincipal User user) {
    // ...
}

@RequestMapping(value = "thing",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public String getThings(,
        @RequestParam(value = "findByComponent", required = false) String findByComponentQuery,
        @AuthenticationPrincipal User user) {
    // ...
}