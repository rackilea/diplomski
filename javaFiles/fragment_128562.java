@GetMapping("/searchCustomer")
public String searchCustomer(Model model) {
    model.addAttribute("customerBySsnForm", new Customer());
    return "searchCustomer";
}

@PostMapping("/showCustomer")
public String showCustomer(@ModelAttribute("customerBySsnForm") Customer customer, Model model) {
    String ssn = customer.getSsn();
    customer = service.getCustomerBySsn(ssn).get();
    model.addAttribute("customerInShowCustomer", customer);
    return "showCustomer";
}