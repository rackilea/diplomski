@RequestMapping(value = { "/employee" }, method = RequestMethod.GET)
public ModelAndView listEmployee() {
    System.out.println("Kontroler EmployeeController");
    LinkedList<String> list = getList();
    ModelAndView map = new ModelAndView("index");
    map.addObject("lists", list);

    return map;
}