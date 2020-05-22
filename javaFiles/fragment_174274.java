@RequestMapping(value = "/some-url, method = RequestMethod.GET)
public String someUrl( BindingResult bindingResult, final Model model, SomeForm form)
{
    getSomeValidator().validate(form, bindingResult);
    if (bindingResult.hasErrors())
    {
        GlobalMessages.addErrorMessage(model, "form.global.error");
        return "errorPage";
    } else {
        return "successPage";
    }
}