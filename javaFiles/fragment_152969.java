@RequestMapping(value = "/read.html")
public String readStudent(Model model, @RequestParam("studentId") Long studentId) {
    Student student = null;
    studentId = 2l;
    try {
        student = serviceFile.readStudent(studentId);
    } catch(Exception e) {
        model.addAttribute("message", "Some thing went wrong !!!! Exception occoured");
        return "message";
    }   
    model.addAttribute("student", student);
    return "read";
}