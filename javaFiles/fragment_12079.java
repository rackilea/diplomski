@RequestMapping(method = RequestMethod.POST) 
public void show(HttpServletRequest request, 
    @ModelAttribute("objectToShow") Object objectToShow) 
{
    ...
}

@ModelAttribute("objectToShow")
public Object createCommandObject() {
    return getCommandClass().newInstance();
}