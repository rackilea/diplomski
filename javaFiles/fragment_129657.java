@RequestMapping("/categories")
@ResponseBody
public Category categories() {
    Category.limitSubCategoryDepth(2);
    return root;
}