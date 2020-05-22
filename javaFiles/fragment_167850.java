@PostMapping(value = "/countries/{parameter1}/get-time", produces = "application/json; charset=utf-8")
public String getTimeOfCitiesByPost(
        @PathVariable(value = "parameter1") String country,
        @RequestParam(value = "city") String city,
        @RequestBody Object myCustomObject

){
    return "the method is not implemented yet";
}