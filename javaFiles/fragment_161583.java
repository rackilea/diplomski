@RequestMapping(value="/cart.html", method = RequestMethod.POST)
public ModelAndView addToChart(@RequestParam String selectedPhone){

    ModelAndView cart = new ModelAndView(selectedPhone);
    return cart;    
}