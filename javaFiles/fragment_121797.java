@PostMapping("/save")
public String save(@Valid @ModelAttribute("phoneBook")Phonebook p, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
        return "redirect:/";
    }else {
        phonebookRepository.save(p);
    }
    return "redirect:/";
}