@Controller
public class CourseController {


// This is called when accessing the form for the first time
@RequestMapping(value = "/admin/course/add", method = RequestMethod.GET)
public String newCourse(Model model, Locale locale) {

    BindableCourse bindableCourse = new BindableCourse();
    model.addAttribute("bindableCourse", bindableCourse);
    model.addAttribute("mainContent", "forms/editCourse");
    addDataToModel(model, locale, companyService.getCurrentlyLoggedInCompany());

    return "adminMain";
}

// This is called when submitting the form. 
// Note that Spring created a BindableCourse for us, 
// filled with the user entered values. This is Spring binding in action.
// Happens behind the scenes.
@RequestMapping(value = "/admin/course/add", method = RequestMethod.POST)
public String addCourse(@ModelAttribute("bindableCourse") BindableCourse bindableCourse, BindingResult result,
                        RedirectAttributes redirectAttributes, Model model, Locale locale) {

    validator.validate(bindableCourse, result);

    if (!result.hasErrors()) {
        Course course = courseService.save(bindableCourse);
        bindableCourse.setPublishable(true);
        redirectAttributes.addFlashAttribute("valid", "true");
        return "redirect:/admin/course/" + course.getId();
    }

    addDataToModel(model, locale, companyService.getCurrentlyLoggedInCompany());
    model.addAttribute("valid", "false");
    model.addAttribute("mainContent", "forms/editCourse");
    return "adminMain";
}