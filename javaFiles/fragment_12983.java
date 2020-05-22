@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, "isKiosk", new PropertyEditorSupport() {
        public void setAsText(String name) {
            setValue(name);
        }
    });
}