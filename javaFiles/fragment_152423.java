@RequestMapping(value = "/MyPage/{id}", method = RequestMethod.GET)
public ModelAndView getPage(@PathVariable Integer id, HttpSession session) {
    User user = (User) session.getAttribute(...);
    if (user != null) {
        ...
    } else {
        ...
    }
}