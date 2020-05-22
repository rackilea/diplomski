@InitBinder
public void initBinder(WebDataBinder binder, WebRequest request) {

        binder.registerCustomEditor(Title.class, "title", new PropertyEditorSupport() {
         @Override
         public void setAsText(String text) {
            setValue((text.equals(""))?null:titleService.getTitle(Integer.parseInt((String)text)));
         }
     });
}