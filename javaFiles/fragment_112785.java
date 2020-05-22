@RequestMapping(value="/validateUser" , method=RequestMethod.POST)
public String processLoginInfo(@ModelAttribute("user") UserBO userBO) throws ServiceBusinessException {
    UserBO user = authenticationService.authenticateUser(userBO.getEmailAddress(), userBO.getPassword());

    return "userDetails";
}