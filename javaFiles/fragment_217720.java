@RequestMapping(value = "/users/{id}/edit", method = RequestMethod.POST)
public ModelAndView updateUser(
        @ModelAttribute("user") User user,
        @RequestParam(value = "newRoles") ArrayList<Long> roles,
        BindingResult bindingResult , Model model) {

    final List<Role> newRoles =
            roles.stream()
                 .map(id -> roleService.findOne(id))
                 .collect(Collectors.toList());
    user.setAuthorities(newRoles);

    userService.update(user);

    return new ModelAndView("redirect:/users");
}