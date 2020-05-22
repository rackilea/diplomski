@RequestMapping(value = "message", method = RequestMethod.GET)
public ModelAndView hotDealDetail() {
    ModelAndView mav = new ModelAndView();
    mav .addAttribute("deal", new Deal());
    return mav;
}