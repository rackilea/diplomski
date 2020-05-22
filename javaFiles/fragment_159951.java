@RequestMapping(value="/createproduct", method=RequestMethod.POST)
public String createProduct(@ModelAttribute("newProduct")Product product, BindingResult result){

   //Here, validate product instance
   //Here, set product/category relationships
   Category category = productService.findOne(product.getCategory().getIdcategory()); //validate for null
   product.setCategory(category);

   productService.create(product);

   return "productcreated";
}