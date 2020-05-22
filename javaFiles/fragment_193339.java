@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Permission.class, new PropertyEditorSupport() {
        @Override
        public void setAsText(String id) throws IllegalArgumentException {
            setValue(userService.getPermission(Integer.parseInt(id)));
        }
    });
}