@GetMapping("/changePassword/{id}")
public String changePasword(Model model) {
    model.addAttribute("currentPassword", ""); //remove
    model.addAttribute("newPassword", ""); //remove
    model.addAttribute("newPasswordConfirmation", ""); //remove

    return "/user/changePassword";
}