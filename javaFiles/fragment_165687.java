@RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public String addProduct(Model model, @RequestBody Product product , 
                                        BindingResult result){
            // you get your desired product object!
    }