@ResponseBody
@RequestMapping(value = "/contact-us", method = RequestMethod.POST)
public String showContactForm(@RequestBody ContactUsDto contactUsDto ) {
    emailService.sendUserRegisterEmail(contactUsDto.getContactName(), contactUsDto.getContactEmail());
    return "index";
}