@RequestMapping(method = RequestMethod.GET)
public View showForm(HttpServletRequest request, ModelMap model) 
{
      String redirectUrl = "http://www.yahoo.com";
      RedirectView view = new RedirectView(redirectUrl );
      return view;
}