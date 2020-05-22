@GetMapping(value = "/countries/{parameter1}/get-time", produces = "application/json; charset=utf-8")
public String getTimeOfCities(
    @PathVariable(value = "parameter1") String country,
    @RequestParam(value = "city") String city
){
    return "the method is not implemented yet";
}