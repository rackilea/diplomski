@PostMapping("/category/{categoryId}")
public String categoryEdit(
    @PathVariable Long categoryId,
    @RequestParam(name = "name") String categoryName){

    log.info("Category Id {}, Category Name {}", 
        categoryId, categoryName);
    this.categoryName = categoryName;
    //you can update the database here
    return "redirect:/category/"+categoryId;
}