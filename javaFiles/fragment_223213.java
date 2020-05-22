@InitBinder
public void registerNumbersBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true){
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            try{
                super.setAsText(text);
            }catch (IllegalArgumentException ex){
                setValue(0);
            }
        }
    });
}