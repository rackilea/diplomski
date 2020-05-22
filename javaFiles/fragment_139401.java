@RequestMapping(value = "/add", method = RequestMethod.POST)
public String added(@RequestParam("name") String name, Model model) {
    City city = new City();
    city.setCity(name);
    service.addCity(city);
    model.addAttribute("city", city);
    return "add";
}