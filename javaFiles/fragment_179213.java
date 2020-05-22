@RequestMapping(value = "/product/save")
public String create(Model model) {
    model.addAttribute("productCategories", productCategoryService.findAll());
    model.addAttribute("newproduct", new Product()); //or try to fetch an existing object
    return '<your view path>';
}

@RequestMapping(value = "/product/save", method = RequestMethod.POST)
public String create(Model model, @Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
    if(result.hasErrors()){
        //error handling  
        ....
    }else {
        //or calling the repository to save the newProduct
        productService.save(newProduct);
        ....
    }
}