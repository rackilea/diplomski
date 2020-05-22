public class ErrorForm  extends ValidatorForm{
public ActionErrors validateForm(ActionMapping mapping, HttpServletRequest request){
ActionErrors errs= super.validate(mapping, request); 
errs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(WebGlobals.CUSTOM_ERROR));
return errs;
}
}