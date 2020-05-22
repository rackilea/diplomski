@RequestMapping("/logged")
public String welcome(Model model, Pageable page, Sort sort) {
    model.addAttribute("page",topicRepository.findAll(page));
    model.addAttribute("sort",(sort !=null)?sort.iterator().next().getProperty():"");
    return "welcome";
}