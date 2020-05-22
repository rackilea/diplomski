@RequestMapping(value = "/user/add")
public ModelAndView addUserPage() {
    ModelAndView mav = new ModelAndView("/admin/user/addUser");
    List<Group> groups = groupService.listGroups();
    mav.addObject("groups", groups);
    mav.addObject("user", new User());
    return mav;
}