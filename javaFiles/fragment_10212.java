@PostMapping("/")
    public String receive(@ModelAttribute ModelForm form_model, ModelMap modelMap){

        //other code to call service layer & save the data

        //Commented new object creation for FormModel
        //FormModel form_model = new FormModel();

        modelMap.addAttribute("form_model", form_model);
        modelMap.addAttribute("demo", "abc");

        return "main_template";
    }