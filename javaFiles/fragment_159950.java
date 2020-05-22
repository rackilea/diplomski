//Here, add a Product instance to model as you have done for categories, for binding product information from JSP.
@RequestMapping("/newproduct")
public String newcategory(Model model) {

   List<Category> categories = categoryService.getAllCategories();
   model.addAttribute("categories",categories);
   model.addAttribute("newProduct",new Product()); //missing
   return "newproduct";
}