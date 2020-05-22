@PostMapping("/save")
public String save(@Valid @RequestParam("phonenumber")String phonenumber, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
        return "redirect:/";
    }else {
        phonebookRepository.save(p);
    }
    return "redirect:/";
}