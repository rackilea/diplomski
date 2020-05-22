@RequestMapping(value = "/add/{id}")
public String addPage(@PathVariable("id") String id, Model model) {
    InvoiceData invoiceData = new InvoiceData();
    model.addAttribute("contractorid", id);
    model.addAttribute("invoicedata", invoiceData);
    return "add";
}