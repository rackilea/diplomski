@RequestMapping(value = "http/exception", method = RequestMethod.GET)
public ModelAndView exception2()
{
    ModelAndView modelAndview;
    try {
        generateException();
        modelAndView = new ModelAndView("success.jsp");
    } catch(IndexOutOfBoundsException e) {
        modelAndView = handleException();
    }
    return modelAndView;
}

private void generateException(){
    throw new IndexOutOfBoundsException();      
}

private ModelAndView handleException(){
     return new ModelAndView("error.jsp");
}