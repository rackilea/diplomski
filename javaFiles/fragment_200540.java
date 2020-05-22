@RequestMapping("/update")
public String Update(@RequestParam(value = "this") int updateId,Model model,String newName,String newSurname,String newCountry) {
    model.addAttribute("id",updateId);
    if (updateId >= personList.size()) {
        throw new EntityNotFoundException();
    }
    // ...