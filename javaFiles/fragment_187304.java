import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/results/{id}", method=RequestMethod.GET)
public String detail(@PathVariable(value="id") String id, Model model) {
    DentistVisitDTO dentistVisit = repository.findById(id);
    System.out.println("GET /results [" + id + "]");
    model.addAttribute("dentistVisit", dentistVisit);
    return "details";
}