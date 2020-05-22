@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home( Model model) {
    List<Gender> enums = Arrays.asList(Gender.values());
    model.addAttribute("enums",enums);
    System.out.println(enums.size());
    return "home";
}