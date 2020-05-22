@RequestMapping(value = "/objectcache", method = RequestMethod.GET)
public ModelAndView objectCache(@RequestParam("operation") String operation,
        HttpServletRequest req) {

    List<String> cacheReturnValue = new ArrayList<String>();

    if (operation.equalsIgnoreCase("reload")) {
        cacheReturnValue = this.reloadCache();
    }

    ModelAndView mav = new ModelAndView("/utils/objectCache");
    mav.addObject("results", cacheReturnValue);
    mav.addObject("operation", operation);
    return mav;
}