@RequestMapping("/update")
public String Update(@RequestParam(value = "this") int updateId,Model model,String newName,String newSurname,String newCountry) {
    model.addAttribute("id",updateId);
    if (updateId < personList.size()) {
        model.addAttribute("name",personList.get(updateId).getName());
        model.addAttribute("surname",personList.get(updateId).getSurname());
        model.addAttribute("country",personList.get(updateId).getCountry());
    // ...
}