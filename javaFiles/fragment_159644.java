@RequestMapping(value = "/submit", method = RequestMethod.POST, params = "addToCart")
public String addToCart(HttpServletRequest request, Model uiModel) {
    //your code
}

@RequestMapping(value = "/submit", method = RequestMethod.POST, params = "favourite")
public String addToFavorites(HttpServletRequest request, Model uiModel) { 
    //your code
}