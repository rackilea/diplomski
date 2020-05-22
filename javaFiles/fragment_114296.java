@RequestMapping(value="/refund", method=RequestMethod.GET)
public String refund(Model model, RedirectAttributes redirectModel) throws PersistenceException{

    //...

    redirectModel.addFlashAttribute("messages", message);
    redirectModel.addFlashAttribute("changes", changes);

    return "redirect:/";
}