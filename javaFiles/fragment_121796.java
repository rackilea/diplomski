@RequestMapping(value = {"/"}, method = RequestMethod.GET)
        public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {

            //your code 

            model.addAttribute("phoneBook", new Phonebook());
            return "index";
        }