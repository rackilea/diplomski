String categoryName = "Information technology";

@GetMapping("/category/{categoryId}")
public String category(@PathVariable Long categoryId, ModelMap modelMap){
    modelMap.put("categoryId", categoryId);
    //try to get the category detail object from DB
    Category category = new Category();
    category.setId(categoryId);
    category.setName(categoryName);

    modelMap.put("category", category);
    return "category-detail";
}