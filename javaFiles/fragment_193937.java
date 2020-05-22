@RequestMapping(method=RequestMethod.POST, params={"validate", "type=bean1"})
public String validate1(@Valid Bean1 bean, BindingResult result){
    return doValidate(bean, result);
}
@RequestMapping(method=RequestMethod.POST, params={"validate", "type=bean2"})
public String validate2(@Valid Bean2 bean, BindingResult result){
    return doValidate(bean, result);
}
private String doValidate(IBean bean, BindingResult result){
    List<ObjectError> errors = bean.validate();
    for(ObjectError e: errors){
        result.addError(e);
    }

    //redirecting, etc
}