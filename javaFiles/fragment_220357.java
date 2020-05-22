@RequestMapping(value="/api/category/page", method=RequestMethod.GET)
@Produces("application/json")
public List<Category> getCategoryList() {
  Page<Category> pageCategory = categoryService.findAll(new PageRequest(0, 10));
  List<Category> catgoryList = pageCategory.getContent(); /*missed this conversion in my original post */
  return catgoryList;
}