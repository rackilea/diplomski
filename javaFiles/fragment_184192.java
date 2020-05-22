public String test(
                @ModelAttribute("userModel") final Object UserModel,
                final BindingResult bindingResult,
                final Model model, 
                final RedirectAttributes redirectAttributes)
    ii) Inside the method added code to add flash attribute to redirectAttributes 
redirectAttributes.addFlashAttribute("userModel", mapping1FormObject);