@RequestMapping(value = "/all", method = RequestMethod.GET)
public CommonResponse getAll(@RequestParam(required = false) Optional<Integer> month, 
                             @RequestParam(required = false, defaultValue = "0") int year) {

    if (month.isPresent()) {
       return getByMonth(month.get, year);
    }

    return getAll();
}