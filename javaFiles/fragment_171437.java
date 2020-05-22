@RequestMapping(value = "/", method = RequestMethod.GET)
public String home(Locale locale, Model model) {
    List<Item> ListItem = new ArrayList<Item>();

    ListItem.add(new Item("1","Pencil"));
    ListItem.add(new Item("2","Paper"));

    model.addAttribute("Item", ListItem); // This is important

    return "item";
}