@RequestMapping("/subject/new")
public String addSubject(Model model){
    Subject subject =new Subject();
    model.addAttribute("subject",subject);
    List<Course> courseDetail= courseDAO.findAll();
    model.addAttribute("courses",courseDetail);
    return "addSubject";
}