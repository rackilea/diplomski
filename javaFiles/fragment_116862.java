@InitBinder("findDocByName")
public void initBinderByName(WebDataBinder binder) {
    binder.setDisallowedFields(new String[]{"distance","zipcode"});
}


@InitBinder("findDocByLocation")
public void initBinderByZipCode(WebDataBinder binder) {
    binder.setDisallowedFields(new String[]{"distance","name"});
}