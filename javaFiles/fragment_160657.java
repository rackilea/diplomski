@Controller
public TermsAndConditionsController {

  @Resource 
  private UserService userService;
  @Resource 
  private ModelService modelService;

  @RequestMapping(value = "/acceptTermsAndConditions", method = RequestMethod.POST) 
  @ResponseBody
  @ResponseStatus(value = HttpStatus.OK)
  public void acceptTermsAndConditions() {
    UserModel user = userService.getCurrentUser();
    if (user instanceof CustomerModel && !userService.isAnonymousUser(user)) {
      CustomerModel customer = (CustomerModel) user;
      customer.setAcceptedTermsAndConditions(true);
      modelService.save(customer);
    }
  }
}