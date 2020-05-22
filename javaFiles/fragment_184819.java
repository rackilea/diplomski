@Controller
public class FormController {

    private ListStore getList;

    @RequestMapping(value="/ApplicationForm.html", method=RequestMethod.GET)
    public String displayForm(@ModelAttribute UserData userData, Model model){

        model.addAttribute("age", getList.ageList());
        return "ApplicationForm";
    }

    @RequestMapping(value="/ApplicaitonForm.html", method=RequestMethod.POST)
    public String processForm(@Valid UserData data, 
                              BindingResult result, 
                              Model model, 
                              @RequestParam(value="name", required=true) String name, 
                              @RequestParam("age") String age, 
                              RedirectAttributes redirectAttributes) {

        if(result.hasErrors()){
            System.out.println("It has some errors !!!!!!!!");
            return displayForm(data, model); /* THIS IS THE TRICK :) */
        }

        redirectAttributes.addFlashAttribute("name", name);
        redirectAttributes.addFlashAttribute("age", age);

        return "redirect:/DisplayFormDetails.html"; // Redirect here to follow Post/Redirect/Get pattern
    }

    @RequestMapping(value="/DisplayFormDetails.html", method=RequestMethod.GET)
    public String displayFormDetails(Model model){
        // name and age are already in model due to use of RedirectAttributes
        return "DisplayFormDetails";
    }
}