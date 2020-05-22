@InitBinder
protected void initBinder(WebDataBinder binder) {

    binder.registerCustomEditor(Bar.class, "bar", new PropertyEditorSupport(Bar.class) {
        @Override
        public String getAsText() {
            if(null != getValue()) {
                return ((Bar) getValue()).getId();
            } else {
                return StringUtils.EMPTY;
            }
        }
        @Override
        public void setAsText(String text) {
            if(!StringUtils.isEmpty(text)) {
                setValue(UtilityClassUtils.getBarById(text));
            }
        }
    });
}