@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String displayProfile(Map<String, Object> model) {
        model.put("profileForm", new ProfileForm());
        return "profile/profilePage";
    }

    @PostMapping("/profile")
    public String saveProfile(@ModelAttribute("profileForm") ProfileForm profileForm) {
        System.out.println("Profil: " + profileForm);
        return "redirect:/profile";
    }
}