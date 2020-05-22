@InitBinder
protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws     Exception {
binder.registerCustomEditor(Category.class, "categories", new PropertyEditorSupport() {
@Override
public void setAsText(String text) {
    Category c = categoryService.findById(Integer.parseInt(text));
    setValue(c);
}
});