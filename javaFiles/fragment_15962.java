@RequestMapping(value="/home", method = {RequestMethod.POST})
public ModelAndView homepAge(@ModelAttribute("homeForm") HomeForm homeForm, BindingResult errors,
                             HttpServletResponse response, HttpServletRequest request) throws IOException {
    String referer = request.getHeader("referer");
    return new ModelAndView("redirect:" + referer, model);
}