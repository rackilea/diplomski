@RequestMapping(value="/search") 
public String search(ModelMap model, @ModelAttribute("foo") Foo foo,
          HttpServletRequest request) {

     //here 'foo' will be added to 'model' and mapped to 'foo'
     .....
}