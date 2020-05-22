@ModelAttribute("foo")
public Foo createFoo(@RequestParam("bar") int bar) {
   return new Foo(bar);
}


@RequestMapping(...)
public ModelAndView baz(HttpServletRequest req, HttpServletResponse response,
    @ModelAttribute("foo") Foo foo) {
   ...
}