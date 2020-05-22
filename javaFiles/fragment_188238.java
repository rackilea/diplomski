@ModelAttribute
public void populateModel(Model model,
        @RequestParam(value = "cur", required = false) String curString,
        @RequestParam(value = "delta", required = false) String deltaString,
        @RequestParam(value = "orderByCol", required = false) String orderByCol,
        @RequestParam(value = "orderByType", required = false) String orderByType) {

    model.addAttribute("progettiCount", projectService.getProgettiCount());
    model.addAttribute("projectFilter", projectFilter);
    model.addAttribute("projectList", projectService.getProgettiList(projectFilter.getCur(), projectFilter.getDelta(),
                    projectFilter.getOrderByCol(), projectFilter.isAsc()));
}