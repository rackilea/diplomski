public class ShowTermsAndConditionsPopupBeforeViewHandler implements BeforeViewHandler {

  @Resource 
  UserService userService;

  @Override
  public void beforeView(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
    UserModel user = userService.getCurrentUser();
    if (user instanceof CustomerModel && !userService.isAnonymousUser(user)) {
      CustomerModel customer = (CustomerModel) user;
      modelAndView.addObject("showTermsAndConditionsPopup", BooleanUtils.isNotTrue(customer.isTermsAndConditionsAccepted()));
    } else {
      modelAndView.addObject("showTermsAndConditionsPopup", false);
    }
  }
}