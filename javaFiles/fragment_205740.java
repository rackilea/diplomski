@RequestMapping(value = "/showAbc", method = RequestMethod.POST)
public ModelAndView showAbc(@RequestBody Abc abcInstance) {
    return new ModelAndView("abc",abcService.get());
}

@RequestMapping(value = "/showBcd", method = RequestMethod.POST)
public ModelAndView showBcd(@RequestParam String bcdId){
    // You should move this repo call to bcdService.java
    Abc abc = abcRepository.findByBcdId(bcdId);
    //Use a normal service call to get the instance instead of a API call
    return new ModelAndView("abc",abcService.getViaInstance(abc));
}