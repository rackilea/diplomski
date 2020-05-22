@RequestMapping(method = {RequestMethod.GET})
public String showForm(Map<String, Object> model, HttpServletRequest request) {
    AuthenticationForm authenticationForm = (AuthenticationForm) model.get("secure/main");
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        System.out.println(cookie.getValue());
        if (cookie.getName().equals("clientId")) {
           authenticationForm.setClientId(cookie.getValue());   //Just added this code to this method
        } else if (cookie.getName().equals("operatorId")) {
           authenticationForm.setOperatorId(cookie.getValue());
        }
    }
    return MAIN_FORM_MAPPING;
}