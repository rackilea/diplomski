@RequestMapping(value="/test/{myParam}", method=RequestMethod.GET)
public ModelAndView myMethod(@PathVariable("myParam") String param) { 
     ModelAndView mv = new ModelAndView();
     mv.setViewName("index"); // now put index.jsp in /WEB-INF/views
     // try passing the input back to the view so you can play around
     // with the view/parameter handling
     mv.addObject("variableName", param); 
}