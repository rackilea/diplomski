@RequestMapping("/schaltung")
public String schaltung(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder, Model model) throws IOException {
    ProductsWeb productsWeb = new ProductsWeb();
    List<String> list = new ArrayList<String>();
    list=productsWeb.schaltung("");
    model.addAttribute("type", list);
    model.addAttribute("testOrder", testOrder);
    return "schaltung";
}