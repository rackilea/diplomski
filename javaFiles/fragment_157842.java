@GetMapping(value = "/states", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public List<MyObject> loadStates(@RequestParam(name = "state", defaultValue = "NY", required = false) String[] states) {
    Arrays.sort(states);
    return getStates()
            .stream()
            .filter(s -> Arrays.binarySearch(states, s.getState()) > -1)
            .collect(Collectors.toList());
}