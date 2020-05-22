@RequestMapping("/subject")
public String viewHomePage(Model model){
    List<Subject> subjectDetails= subjectDAO.findAll();
    List<Course> courseDetail= courseDAO.findAll();
    model.addAttribute("subjectDetails",subjectDetails);
    model.addAttribute("courses",courseDetail);
    return "subject";
}