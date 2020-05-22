@RequestMapping(value = "/update", method = RequestMethod.POST)
public ModelAndView update(@ModelAttribute("user") User user){
    User user1 = user;
    userService.update(user1);
    return new ModelAndView("redirect:/list");
}