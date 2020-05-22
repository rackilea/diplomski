@RequestMapping(value = "/delete", method = RequestMethod.GET)
public String DeleteAction(Model model, Object object, @RequestParam int id RedirectAttributes attributes) {
    object.delete(id);
    attributes.addFlashAttribute("success", "Object has been removed successfully.");
    return "redirect:" + "index";
}