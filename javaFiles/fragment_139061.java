public SheetPage(String title, String idPojo, final FormPage fPage) {
    Link back = new Link("back"){
       private static final long serialVersionUID = 1L;

       public void onClick() {
         setResponsePage(fPage);
      };
    };
}