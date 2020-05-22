@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(
    @ModelAttribute @Valid Email email,
    BindingResult result,
    Model model,
    @PathVaribale("categoryId") UUID categoryId
) {
    // saving entity, etc

    return String.format("redirect:/emails/%s/", categoryId.toString());
    //if category object is needed and not just id then fetch it with Category c = addCategory(categoryId).
}