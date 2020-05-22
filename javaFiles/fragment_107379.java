@RequestMapping(value="/add", method = RequestMethod.POST)
public String postCustomer(@ModelAttribute Customer c, @ModelAttribute Address a){
    addressDao.addAddress(a);
    c.setAddress(a);
    customerDao.addCustomer(c);
    return "redirect:/customer";
}