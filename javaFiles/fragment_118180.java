@RequestMapping(value = "/something/{enquiry}")
public String method(@PathVariable Enquiry enquiry) {...}


@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Enquiry.class, new PropertyEditorSupport() {
        @Override
        public String getAsText() {
            return ((Enquiry) this.getValue()).toString();
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(new Enquiry(text));
        }
    });
}