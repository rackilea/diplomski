@InitBinder 
protected void initBinder(WebDataBinder binder) { 
binder.setValidator(new CustomFormValidator(binder.getValidator())); 
}

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addCustomer(@Valid Customer customer, BindingResult result) {

        if (result.hasErrors()) {
            return "form";
        } else {
            return "success";
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public String customerForm(ModelMap model) {

        model.addAttribute("customer", new Customer());
        return "form";

    }

}