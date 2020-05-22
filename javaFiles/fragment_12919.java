/**
 * This is only prove that it works.
 * You should not update the contact directly in the controller (this is only a shortcut in for the example).
 * If you load and update the contact in an method that is @Transactional, than you can remove the @Transactional from this
 * controller method.
 */
@Transactional
@RequestMapping(value = "/doedit/{contactId}", method = RequestMethod.POST)
public String editContact(@PathVariable("contactId") final Integer contactId, final Contact editedContact) {

  //contactService.editContact(contactId);

    Contact contact = contactService.getContact(contactId);
    contact.setFirstname(editedContact.getFirstname()); //only first name for the example

    return "redirect:/index";
}