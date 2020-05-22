@RequestMapping(value = { "/page1" }, method = RequestMethod.POST)
        public String test1(
                @ModelAttribute("userModel") final Object userModel,
                final BindingResult bindingResult,
                final Model model, 
                final RedirectAttributes redirectAttributes) {

            redirectAttributes.addFlashAttribute("userModel", mapping1FormObject);

            return "redirect:page2";
        } 
//Controller2   


@RequestMapping(value = "/page2", method = RequestMethod.GET)
        public String test2(
                @ModelAttribute("userModel") final Object userModel,
                final BindingResult bindingResult,
                final Model model) {


            return "new/view";  
        }