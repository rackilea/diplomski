@RequestMapping(value="/account/{id}", method=GET)
public String showOrder(@PathVariable("id") long id, Model model) {
    Account account = accountServices.findAccountById(id);

    if (account == null) throw new AddressNotFoundException(id);
    model.addAttribute(account);
    return "accountDetail";
}