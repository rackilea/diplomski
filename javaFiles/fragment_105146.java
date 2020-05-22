@RequestMapping("/users/{id}")
 public String detail(Model model, @PathVariable int id){
     model.addAttribute("users", userService.findOneWithRole(id));

     return "user-detail";
 }