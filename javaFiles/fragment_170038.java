@ControllerAdvice
public class BugetControllerAdvice {

    @ModelAttribute
    public void addBugetToModel(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        Manager mgr = managerService.findOne(username);
        model.addAttribute("buget", mgr.getTeam().getTeamBuget());
    }
}