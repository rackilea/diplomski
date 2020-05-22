@ModelAttribute("user")
public AdminUser getAdminUser(@RequestParam(value="id", required=false) Integer id) {
    if(id==null){
        return new AdminUser();
    }
    return userService.findAdminById(id);
}