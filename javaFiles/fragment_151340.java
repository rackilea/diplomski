@RequestMapping(value="/saveContact", method=RequestMethod.POST)
public String create(@ModelAttribute("newContact")Contacts contact, BindingResult result, SessionStatus status)
{
    validator.validate(contact, result);
    if (result.hasErrors()) 
    {               
        return "newContact";
    }
    try {
        contactsDAO.save(contact);
    }
    catch (DataIntegrityViolationException ex) {
        result.reject("DUPKEY");
        return "newContact";
    }
    status.setComplete();
    return "redirect:viewAllContacts.do";
}