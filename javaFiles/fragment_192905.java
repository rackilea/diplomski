@RequestMapping("handler.do")
public String myHandler(@Valid @ModelAttribute("form") SomeFormBean myForm, BindingResult result, Model model) {
    if(result.hasErrors()) {
      ...your error handling...
    } else {
      ...your non-error handling....
    }
}