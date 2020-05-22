@RequestMapping(value = "/add", method = RequestMethod.POST)
public String addStudent(
        @Valid @ModelAttribute("studentForm") Student student,
        BindingResult result, Model model) {

    if (result.hasErrors()) {
        logger.info("Returning add page with errors");
        initLists(model);
        return "addstudent";
    }
        //Stuffs to save in database 
    return "redirect:add";
}