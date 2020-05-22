@Autowired
private IUserService service;

@RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
public String confirmRegistration
  (WebRequest request, Model model, @RequestParam("token") String token) {

    Locale locale = request.getLocale();

    VerificationToken verificationToken = service.getVerificationToken(token);
    if (verificationToken == null) {
        String message = messages.getMessage("auth.message.invalidToken", null, locale);
        model.addAttribute("message", message);
        return "redirect:/badUser.html?lang=" + locale.getLanguage();
    }

    User user = verificationToken.getUser();
    //Calendar cal = Calendar.getInstance();
   // if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
     //   String messageValue = messages.getMessage("auth.message.expired", null, locale)
       // model.addAttribute("message", messageValue);
       // return "redirect:/badUser.html?lang=" + locale.getLanguage();
    //} 

    user.setEnabled(true); 
    service.saveRegisteredUser(user); 
    return "redirect:/login.html?lang=" + request.getLocale().getLanguage(); 
}