@RequestMapping(method=RequestMethod.GET)
public String initializeForm(ModelMap model) {
    Map<Integer, String> priority = new LinkedHashMap<Integer, String>();
    priority.put(1, "low");
    priority.put(2, "medium");
    priority.put(3, "high");

    PriceIncrease priceIncrease = new PriceIncrease();  //Not sure of constructor
    model.addAttribute("priceIncrease", priceIncrease);

    model.addAttribute("priorityList", priority);

    return "priceincrease";

  }
}