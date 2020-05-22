@PostMapping("/logout-user")
public String logout(HttpServletRequest request, RedirectAttributes attrs) {
    new SecurityContextLogoutHandler().logout(request, null, null);

    // this attribute will be received in /login
    attrs.addFlashAttribute("logout", true);

    return "redirect:/login";
}