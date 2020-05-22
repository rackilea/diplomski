@InitBinder
public void initBinder(WebDataBinder binder, HttpServletRequest request) {
    String productType = request.getParam("type");

    PropertyEditor productEditor;
    if("album".equalsIgnoreCase(productType)) {
        productEditor = new AlbumEditor();
    } else if("album".equalsIgnoreCase(productType))
        productEditor = new SingleEditor();
    } else {
        throw SomeNastyException();
    }
    binder.registerCustomEditor(Product.class, productEditor);
}